import java.util.Scanner;
import java.util.List;
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        imprimirIntroducao();
        
        Personagem jogador = criarPersonagem();

        System.out.println("Ao chegar nos portões da vila, você encherga um multidão ao redor de um quadro de avisos.");
        aguardarEnter();
        System.out.println("Chegando mais perto é possivel ver um aldeão pregando um novo aviso no quadro...");
        aguardarEnter();
        System.out.println("Seus ouvidos são tomados por uma maré sonora vinda das milhares de vozes ao seu redor.");
        aguardarEnter();
        System.out.println("----------------------------------------");

        Inimigo inimigo = criarInimigo();

        System.out.println("\n--- A BATALHA COMEÇA! ---");
        
        boolean emCombate = true;
        while (emCombate) {

            // --- TURNO DO JOGADOR ---
            
            jogador.processarBuffs(); // Faz a contagem do buff do jogador
            
            exibirStatus(jogador, inimigo);
            int escolha = exibirOpcoesJogador(jogador);
            
            boolean turnoConcluido = executarAcaoJogador(escolha, jogador, inimigo);

            if (!turnoConcluido) {
                continue; 
            }
            
            if (inimigo.getPontosdeVida() <= 0) {
                System.out.println("\n🎉 Você derrotou " + inimigo.getNome() + "! 🎉");
                emCombate = false;
                continue; 
            }

            aguardarEnter();

            // --- TURNO DO INIMIGO ---
            
            inimigo.processarBuffs(); // Faz a contagem do buff do inimigo
            
            inimigo.decidirAcao(jogador);
            
            if (jogador.getPontosdeVida() <= 0) {
                System.out.println("\n💀 " + jogador.getNome() + " foi derrotado... Fim de Jogo. 💀");
                emCombate = false; 
            }

            if (emCombate) {
                aguardarEnter();
            }
    }
    
    System.out.println("\nObrigado por jogar!");
    scanner.close();
}
    /**
     * Cuida da criação do personagem, seleção de classe e nome.
     */
    private static Personagem criarPersonagem() {
        System.out.println("Escolha sua classe:");
        System.out.println("1. Bruxo (Disponível)");
        System.out.println("2. Mago (Indisponível)");
        System.out.println("3. Assassino (Indisponível)");
        
        int classe = 0;
        while (classe != 1) {
            System.out.print("Opção: ");
            classe = scanner.nextInt();
            if (classe != 1) {
                System.out.println("Classe indisponível. Por favor, escolha Bruxo.");
            }
        }
        scanner.nextLine(); // Limpa o buffer do scanner

        System.out.print("\nDigite o nome do seu Bruxo: ");
        String nome = scanner.nextLine();

        // Cria o inventário inicial do jogador
        Inventario mochila = new Inventario();

        mochila.adicionar(new Item("Poção de Cura", "Restaura 25 PV.", Efeito.CURA, 3));
        mochila.adicionar(new Item("Andorinha", "Restaura 2 Sinais.", Efeito.CURA_SINAL, 2));
        mochila.adicionar(new Item("Trovoada", "Aumenta ataque em 5.", Efeito.BUFF_ATAQUE, 1));


        // Bruxo(nome, pv, atqFísico, def, inventario, poderDeSinal)
        Bruxo jogador = new Bruxo(nome, 100, 5, 14, mochila, 5);
        System.out.println("\n" + nome + ", o Bruxo, foi criado!");
        
        return jogador;
    }

    /**
     * Cria e retorna o primeiro inimigo.
     */
    private static Inimigo criarInimigo() {
        Inventario mochilaGoblin = new Inventario();
        // Inimigo(nome, pv, atq, def, inventario)
        Inimigo inimigo = new Inimigo("Afogador", 50, 4, 12, mochilaGoblin);
        
        System.out.println("\nVocê chega perto do rio nevoluso...");
        System.out.println("De repente, um " + inimigo.getNome() + " pula das águas!");
        return inimigo;
    }

    /**
     * Mostra o HP do jogador e do inimigo.
     */
    private static void exibirStatus(Personagem jogador, Inimigo inimigo) {
        System.out.println("\n========================================");
        // Mostra status do Jogador
        System.out.print("👤 " + jogador.getNome() + " | HP: " + jogador.getPontosdeVida()+" | Defesa: " + jogador.getDefesa());
        
        // Se for um Bruxo, mostra os Sinais
        if (jogador instanceof Bruxo) {
            // Converte o "Personagem" para "Bruxo" temporariamente
            Bruxo bruxo = (Bruxo) jogador;
            System.out.print(" | Sinais: " + bruxo.getPontosDeSinal() + "/8");
        }
        
        System.out.println("\n----------------------------------------");
        // Mostra status do Inimigo
        System.out.println("👹 " + inimigo.getNome() + " | HP: " + inimigo.getPontosdeVida()+" | Defesa: " + inimigo.getDefesa());
        System.out.println("========================================");
    }

    /**
     * Mostra as opções de ação do jogador e retorna a escolha.
     */
    
    private static int exibirOpcoesJogador(Personagem jogador) {
        System.out.println("É seu turno. O que fazer?");
        System.out.println("1. Atacar (Espada)");

        if (jogador instanceof Bruxo) {
            System.out.println("2. Lançar Igni (Custo: 2 Sinais)");
            System.out.println("3. Lançar Aard (Custo: 1 Sinal)");
            System.out.println("4. Lançar Quen (Custo: 2 Sinais)");
            System.out.println("5. Lançar Axii (Custo: 3 Sinais)"); 
            System.out.println("6. Usar Item");                     
        } else {
            System.out.println("2. Usar Item"); 
        }

        System.out.print("Escolha: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); 
        return escolha;
    }

    private static boolean executarAcaoJogador(int escolha, Personagem jogador, Inimigo inimigo) {
        
        Inventario mochila = jogador.getInventario(); 
        //  Se o jogador for Bruxo esses sãos as opções:
        if (jogador instanceof Bruxo) {
            Bruxo bruxo = (Bruxo) jogador;
            switch (escolha) {
                case 1:
                    bruxo.atacar(inimigo); 
                    return true; // Turno concluído
                case 2:
                    bruxo.lancarIgni(inimigo); 
                    return true; // Turno concluído
                case 3:
                    bruxo.lancarAard(inimigo); 
                    return true; // Turno concluído
                case 4:
                    bruxo.lancarQuen(); 
                    return true; // Turno concluído
                case 5: 
                    bruxo.lancarAxii(inimigo); 
                    return true; // Turno concluído
                case 6:

                // 1. Pega a lista de itens reais do inventário
                List<Item> itens = mochila.listarOrdenado();

                if (itens.isEmpty()) {
                    System.out.println("...você não tem nada para usar.");
                    return false; // Turno NÃO concluído, volta ao menu
                }
                
                // 2. Imprime a lista manualmente com números
                System.out.println("=== INVENTÁRIO ===");
                for (int i = 0; i < itens.size(); i++) {
                    Item item = itens.get(i);
                    // O número do item é (i + 1)
                    System.out.printf("%d. %s (%s) - %d unidades\n", 
                        (i + 1), item.getNome(), item.getEfeito(), item.getQuantidade());
                }
                System.out.println("0. Voltar");
                
                // 3. Pede um NÚMERO
                System.out.print("\nEscolha o item (pelo número) ou 0 para voltar: ");
                int escolhaItem = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                // 4. Lógica da escolha
                if (escolhaItem == 0) {
                    System.out.println("Você guarda o item de volta na mochila.");
                    return false; // Turno NÃO concluído, volta ao menu
                
                } else if (escolhaItem > 0 && escolhaItem <= itens.size()) {
                    // Se a escolha for válida (ex: 1 ou 2)
                    
                    // Pega o item da lista (índice é escolha - 1)
                    Item itemEscolhido = itens.get(escolhaItem - 1);
                    
                    // Pega o NOME do item e manda para o método usarItem
                    String nomeItem = itemEscolhido.getNome();
                    bruxo.usarItem(nomeItem);
                    
                    return true; // Turno concluído
                } else {
                    System.out.println("Número de item inválido!");
                    return false; // Turno NÃO concluído, volta ao menu
                }
                // === FIM DA NOVA LÓGICA ===
                
            default:
                System.out.println("Opção inválida! Você gaguejou e perdeu o turno.");
                return true; // Turno concluído (gasto)
        }
    } else {
        // Lógica para outras classes 
        switch (escolha) {
            case 1:
                jogador.atacar(inimigo);
                return true;
            case 2:
                List<Item> itens = mochila.listarOrdenado();
                if (itens.isEmpty()) {
                    System.out.println("...você não tem nada para usar.");
                    return false; 
                }
                
                System.out.println("=== INVENTÁRIO ===");
                for (int i = 0; i < itens.size(); i++) {
                    Item item = itens.get(i);
                    System.out.printf("%d. %s (%s) - %d unidades\n", 
                        (i + 1), item.getNome(), item.getEfeito(), item.getQuantidade());
                }
                System.out.println("0. Voltar");
                
                System.out.print("\nEscolha o item (pelo número) ou 0 para voltar: ");
                int escolhaItem = scanner.nextInt();
                scanner.nextLine();

                if (escolhaItem == 0) {
                    System.out.println("Você guarda o item de volta na mochila.");
                    return false; 
                
                } else if (escolhaItem > 0 && escolhaItem <= itens.size()) {
                    Item itemEscolhido = itens.get(escolhaItem - 1);
                    String nomeItem = itemEscolhido.getNome();
                    jogador.usarItem(nomeItem);
                    return true; 
                } else {
                    System.out.println("Número de item inválido!");
                    return false; 
                }
            default:
                System.out.println("Opção inválida! Você gaguejou e perdeu o turno.");
                return true;
        }
    }
}

    /**
     * Imprime a história de introdução.
     */
    private static void imprimirIntroducao() {
        System.out.println("========================================");
        System.out.println(" BEM-VINDO AO PROJETO DE RPG");
        System.out.println("========================================");
        System.out.println("Você é um mercenario.");
        System.out.println("Seu caminho o leva a uma vila atormentada de Pomar Branco.");
        System.out.println("Graças a guerra no Norte, as vilas perto da fronteira sofrem com doenças e monstros carniçais.");
        System.out.println("Você espera encontrar trabalho por lá.");
        System.out.println("É hora de se preparar.");
        System.out.println("----------------------------------------");
    }

    /**
     * Pausa o jogo e espera o jogador pressionar Enter.
     */
    private static void aguardarEnter() {
        System.out.println("\n(Pressione Enter para continuar...)");
        scanner.nextLine();
    }
}
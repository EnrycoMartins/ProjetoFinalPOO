import java.util.Scanner;
public class Main {

    // Scanner global para ser usado por todos os métodos
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        imprimirIntroducao();
        
        // 1. CRIAÇÃO DO PERSONAGEM
        // O método criarPersonagem() cuida da seleção de classe e nome
        Personagem jogador = criarPersonagem();

        // 2. CRIAÇÃO DO INIMIGO
        // O Inimigo é criado para a primeira batalha
        Inimigo inimigo = criarInimigo();

        System.out.println("\n--- A BATALHA COMEÇA! ---");
        
        // 3. LOOP DE COMBATE
        boolean emCombate = true;
        while (emCombate) {

            // --- TURNO DO JOGADOR ---
            exibirStatus(jogador, inimigo);
            int escolha = exibirOpcoesJogador(jogador);
            executarAcaoJogador(escolha, jogador, inimigo);
            
            boolean turnoConcluido = executarAcaoJogador(escolha, jogador, inimigo);

            if (!turnoConcluido) {
                // Se o turno não foi concluído (jogador volta pra tela de combate).
                continue; 
            }
            
            // Verifica se o inimigo foi derrotado
            if (inimigo.getPontosdeVida() <= 0) {
                System.out.println("\n🎉 Você derrotou " + inimigo.getNome() + "! 🎉");
                emCombate = false; // Termina o loop de combate
                continue; // Pula o turno do inimigo
            }

            // Pausa para ler
            aguardarEnter();

            // --- TURNO DO INIMIGO ---
            // A classe Inimigo decide o que fazer sozinha!
            inimigo.decidirAcao(jogador);
            
            // Verifica se o jogador foi derrotado
            if (jogador.getPontosdeVida() <= 0) {
                System.out.println("\n💀 " + jogador.getNome() + " foi derrotado... Fim de Jogo. 💀");
                emCombate = false; // Termina o loop de combate
            }

            // Pausa para ler
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

        // Bruxo(nome, pv, atqFísico, def, inventario, poderDeSinal)
        Bruxo jogador = new Bruxo(nome, 100, 5, 14, mochila, 8);
        System.out.println("\n" + nome + ", o Bruxo, foi criado!");
        
        return jogador;
    }

    /**
     * Cria e retorna o primeiro inimigo.
     */
    private static Inimigo criarInimigo() {
        Inventario mochilaGoblin = new Inventario();
        // Inimigo(nome, pv, atq, def, inventario)
        Inimigo inimigo = new Inimigo("Goblin Sorrateiro", 50, 4, 12, mochilaGoblin);
        
        System.out.println("\nVocê entra na floresta escura...");
        System.out.println("De repente, um " + inimigo.getNome() + " pula das sombras!");
        return inimigo;
    }

    /**
     * Mostra o HP do jogador e do inimigo.
     */
    private static void exibirStatus(Personagem jogador, Inimigo inimigo) {
        System.out.println("\n========================================");
        // Mostra status do Jogador
        System.out.print("👤 " + jogador.getNome() + " | HP: " + jogador.getPontosdeVida());
        
        // Se for um Bruxo, mostra os Sinais (usando o getter que você adicionou)
        if (jogador instanceof Bruxo) {
            // Converte o "Personagem" para "Bruxo" temporariamente
            Bruxo bruxo = (Bruxo) jogador;
            System.out.print(" | Sinais: " + bruxo.getPontosDeSinal() + "/6");
        }
        
        System.out.println("\n----------------------------------------");
        // Mostra status do Inimigo
        System.out.println("👹 " + inimigo.getNome() + " | HP: " + inimigo.getPontosdeVida());
        System.out.println("========================================");
    }

    /**
     * Mostra as opções de ação do jogador e retorna a escolha.
     */
    private static int exibirOpcoesJogador(Personagem jogador) {
        System.out.println("É seu turno. O que fazer?");
        System.out.println("1. Atacar (Espada)");
        
        // Mostra opções de magia apenas se for um Bruxo
        if (jogador instanceof Bruxo) {
            System.out.println("2. Lançar Igni (Custo: 2 Sinais)");
            System.out.println("3. Lançar Aard (Custo: 1 Sinal)");
            System.out.println("4. Usar Item");
        } else {
            System.out.println("2. Usar Item"); // Opção 2 para outras classes
        }
        
        System.out.print("Escolha: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner
        return escolha;
    }

    // SUBSTITUA O MÉTODO 'executarAcaoJogador' INTEIRO POR ESTE:

/**
 * Executa a ação do jogador.
 * @return 'true' se o turno foi concluído, 'false' se o jogador cancelou a ação.
 */
private static boolean executarAcaoJogador(int escolha, Personagem jogador, Inimigo inimigo) {
    
    Inventario mochila = jogador.getInventario(); 
    
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
                // === INÍCIO DA MUDANÇA ===
                System.out.println(mochila.toString());

                if (mochila.estaVazio()) {
                    System.out.println("...você não tem nada para usar.");
                    return false; // Turno NÃO concluído, volta ao menu
                }
                
                System.out.print("\nQual item usar? (Ou digite 'voltar' para cancelar): ");
                String nomeItem = scanner.nextLine();

                // Opção de cancelar
                if (nomeItem.equalsIgnoreCase("voltar")) {
                    System.out.println("Você guarda o item de volta na mochila.");
                    return false; // Turno NÃO concluído, volta ao menu
                }
                
                // Se não cancelou, tenta usar o item
                bruxo.usarItem(nomeItem);
                return true; // Turno concluído (mesmo se o item falhar)
                // === FIM DA MUDANÇA ===
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
                System.out.println(mochila.toString());

                if (mochila.estaVazio()) {
                    System.out.println("...você não tem nada para usar.");
                    return false; // Turno NÃO concluído
                }
                
                System.out.print("\nQual item usar? (Ou digite 'voltar' para cancelar): ");
                String nomeItem = scanner.nextLine();

                if (nomeItem.equalsIgnoreCase("voltar")) {
                    System.out.println("Você guarda o item de volta na mochila.");
                    return false; // Turno NÃO concluído
                }
                
                jogador.usarItem(nomeItem);
                return true; // Turno concluído
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
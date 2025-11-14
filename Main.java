import java.util.Scanner;
import java.util.List;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        imprimirIntroducao();
        
        // CRIAÇÃO DO PERSONAGEM
        Personagem jogador = criarPersonagem();

        // Diálogos com Pocho e Regis
        System.out.println("Ao chegar nos portões da vila, você encherga um multidão ao redor de um quadro de avisos.");
        aguardarEnter();
        System.out.println("Chegando mais perto é possivel ver um aldeão pregando um novo aviso no quadro...");
        aguardarEnter();
        System.out.println("Seus ouvidos são tomados por uma maré sonora vinda das milhares de vozes ao seu redor.");
        aguardarEnter();
        System.out.println("Os Aldeões estão furiosos, após se espremer pela multidão para chegar perto ao quadro, você consegue ler o aviso recém pregado.");
        aguardarEnter();
        System.out.println("No papel está escrito: Monstro que perambula na floresta ao redor da vila já matou 20 moradores, recompensa de 1000 gilles para quem trouxer-me a cabeça da fera. Converse com Pocho na cabana do magistrado.");
        aguardarEnter();
        System.out.println("A cabana do magistrado é o maior edifício da vila, lá é onde as politicas da vila acontecem");
        aguardarEnter();
        System.out.println("Você está de frente para a cabana, uma construção robusta feita de pedra e madeira.");
        aguardarEnter();
        System.out.println("Ao bater na porta, você escuta barulho de passos atrás da porta...");
        aguardarEnter();
        System.out.println("Uma voz ecoa atraves da porta:");
        aguardarEnter();
        System.out.println("- O que é?");
        System.out.println("1) Eu vim pelo aviso!");
        System.out.println("2) Eu sou " + jogador.getNome()+"! Quero conversar sobre o contrato!");
        System.out.println("3) Eu quero matar a fera!");
        System.out.println("Digite uma opção:");
        int escolha1 = scanner.nextInt();
        scanner.nextLine(); 
        if (escolha1 == 1){
            System.out.println("Veio é? Pode entrar.");
        }else if(escolha1 == 2){
            System.out.println("Eu não preciso saber seu nome agora, é bem provavel que você morra mesmo, mas pode entrar.");
        }else{
            System.out.println("Muitos quiseram, e muitos estão debaixo da terra desde então. Se tem pouco valor a sua vida, pode entrar.");
        }
        aguardarEnter();
        System.out.println("Ao entrar na cabana, você se depara com um homem que provavelmente já passou por várias experiencias durante a vida");
        aguardarEnter();
        System.out.println("Um sujeito calvo com alguns fios brancos, tem uma barba branca gigante, a barba é grande o bastante pra esconder uma adaga.");
        aguardarEnter();
        System.out.println("O homem velho te olha nos olhos e fala:");
        aguardarEnter();
        System.out.println("- Meu nome é POCHO, sou o vice magistrado.");
        aguardarEnter();
        System.out.println("- Eu cuido de assuntos que o Magistrado não se pode dar ao luxo de perder tempo.");
        aguardarEnter();
        System.out.println("- Já quer sobre o aviso. Aqui vai, o monstro já matou 20 pessoas contando moradores e soldados.");
        aguardarEnter();
        System.out.println("- A maioria dos cadáveres foram encontrados ao norte do vila perto do rio Morskie Oko.");
        aguardarEnter();
        System.out.println("- Todos eles estavam tão estraçalhados que mal podiam ser reconhecidos.");
        aguardarEnter();
        System.out.println("- Os aldeões estão querendo sangue, estão planejando caçar o monstro eles mesmos!");
        aguardarEnter();
        System.out.println("- Obviamente, não posso deixar isso acontecer! Por isso o aviso no quadro.");
        aguardarEnter();
        System.out.println("- Alguma pergunta?");
        System.out.println("1) Onde foi encontrado o cadáver mais recente?");
        System.out.println("2) Tem alguma ideia de que monstro pode ser?");
        System.out.println("3) Algum ferimento que chame atenção nas vitimas?");
        System.out.println("Digite uma opção:");
        int escolha2 = scanner.nextInt();
        scanner.nextLine(); 
        if (escolha2 == 1){
            System.out.println("- Pelo que recebi, ele foi encontrado morto hoje de manhã perto das docas do leste.");
        }else if(escolha2 == 2){
            System.out.println("- Não faço ideia, não conheço monstros e os moradores também não.");
        }else{
            System.out.println("- Pelo que os soldados relataram, a grande maioria estavam completamente destroçados, só eram reconhecidos por suas roupas.");
        }
        aguardarEnter();
        System.out.println("- Bom, isso é tudo que sei. Se quiser saber detalhes do cadáver ou do local, vá falar com Regis o pescador que encontrou o coitado hoje de manhã. Ele sempre veste um gibão verde, não deve ser dificil de achar.");
        aguardarEnter();
        System.out.println("- Agora saia daqui, tenho muita coisa pra fazer.");
        aguardarEnter();
        System.out.println("Pocho com uma face indiferente te põe pra fora.");
        aguardarEnter();
        System.out.println("Pocho mencionou um pescador chamado Regis, talvez ele consiga te ajudar a encontrar pistas do monstro.");
        aguardarEnter();
        System.out.println("E aparentemente ele passa a maior parte do tempo nas docas, talvez esteja lá agora");
        aguardarEnter();
        System.out.println("Alguns minutos depois...");
        aguardarEnter();
        System.out.println("Chegando nas docas do leste, o movimento é baixo, com apenas alguns poucos pescadores.");
        aguardarEnter();
        System.out.println("Olhando de longe, é possível ver um sujeito que bate com a descrição." );
        aguardarEnter();
        System.out.println("Um homem na casa dos 40 anos usando um gibão verde, deve ser Regis. É bom ir conversar com ele.");
        aguardarEnter();
        System.out.println("Regis percebe sua aproximação e diz:");
        aguardarEnter();
        System.out.println("- Você está caçando o monstro?");
        aguardarEnter();
        System.out.println("Você demonstra surpresa em sua feição.");
        aguardarEnter();
        System.out.println("- Acertei? Bom, ninguém parecido com você tinha aparecido antes, por isso pensei que fosse o caso.");
        aguardarEnter();
        System.out.println("- Mas, eu não sei como eu posso te dizer mais do já contaram...");
        aguardarEnter();
        System.out.println("1) Onde você encontrou o cadáver?");
        System.out.println("2) Como estava o corpo? Descreva com detalhes.");
        System.out.println("Digite uma opção:");
        int escolha3 = scanner.nextInt();
        scanner.nextLine(); 
        if (escolha3 == 1){
            System.out.println("- Eu o achei jogado perto da beira do rio hoje de manhã. Estava bem cedo, achei que meus olhos ainda estavam acordando.");
        }else{
            System.out.println("- Estava horrível, tenho 43 anos e nunca tinha visto isso. O peito do homem estava tão aberto que era possivel ver do outro lado, seus braços sendo segurados apenas pelos ossos e partido da cintura para baixo");
        }
        aguardarEnter();
        System.out.println("- Suponho que vai perseguir a fera independente do eu digo, então procure ao redor do rio nas proximidades da floresta fora da vila, provavelmente terá algo lá.");
        aguardarEnter();
        System.out.println("- Tenha cuidado, já morreram muitos. Não quero encontrar seu corpo boiando amanhã.");
        aguardarEnter();
        System.out.println("Seguindo o que Regis te disse, você segue o rio pelas proximidades da floresta.");
        aguardarEnter();
        System.out.println("Aproximadamente 1 hora andando nas margens do rio, você sente um cheiro podrido não tão forte. Algo foi morto recentemente.");
        aguardarEnter();
        System.out.println("Conforme você avança em direção ao odor, uma névoa lentamente se forma ao redor no local.");
        aguardarEnter();
        System.out.println("Ao chegar no local, você encontra uma mulher morta. Pelo estado do corpo, está morta por pelo menos algumas poucas horas.");
        aguardarEnter();
        System.out.println("Os ferimentos estão parecidos com o que mencionaram antes, estraçalhado mas essa está com o coração arrancado. Aparentemente, o monstro demora para matar suas vitimas, ele os desmembra parte por parte.");
        aguardarEnter();
        System.out.println("Um sadismo desse não é qualquer monstro que possuí, você percebe ao olhar no chão um rastro de sangue fresco. Segui-lo talvez o leve para algum lugar.");
        aguardarEnter();
        System.out.println("Mas antes que fosse seguí-lo, você escuta movimentação no rio atras de vocé.");
        aguardarEnter();
        
        // 3. CRIAÇÃO DO INIMIGO 
        Inimigo afogador = criarAfogador();

        // 4. LOOP DE COMBATE 
        System.out.println("\n--- A BATALHA (1) COMEÇA! ---");
        
        boolean emCombate = true;
        boolean jogadorVenceu = false; 
        
        while (emCombate) {
            jogador.processarBuffs(); 
            exibirStatus(jogador, afogador);
            int escolha = exibirOpcoesJogador(jogador);
            boolean turnoConcluido = executarAcaoJogador(escolha, jogador, afogador);

            if (!turnoConcluido) { continue; }
            
            if (afogador.getPontosdeVida() <= 0) {
                System.out.println("\n🎉 Você derrotou " + afogador.getNome() + "! 🎉");
                emCombate = false;
                jogadorVenceu = true; 
                continue; 
            }

            aguardarEnter();

            afogador.processarBuffs(); 
            afogador.decidirAcao(jogador);
            
            if (jogador.getPontosdeVida() <= 0) {
                System.out.println("\n💀 " + jogador.getNome() + " foi derrotado... Fim de Jogo. 💀");
                emCombate = false; 
            }

            if (emCombate) { aguardarEnter(); }
        } // FIM DO COMBATE 

        // LOOT
        if (jogadorVenceu) {
            System.out.println("O cheiro do cadáver atraiu o afogador. É improvável que tenha sido um afogador ou bruxa aquática, eles geralmente são monstros abutres que comem carcaças");
            aguardarEnter(); 
            System.out.println("Se bem que você conheçe muitas historias de afogadores atacando pescadores, mas nenhum afogador tortura suas vitimas antes de matar.");
            aguardarEnter();
            System.out.println("Seria um desperdicio deixar o corpo do afogador aprodrecer, é dito que glândulas de afogador ajudam a curar doenças");
            aguardarEnter();

            Inventario mochilaDoJogador = jogador.getInventario();
            Item pocaoRecompensa = new Item("Poção de Cura", "Restaura 25 PV.", Efeito.CURA, 1);
            mochilaDoJogador.adicionar(pocaoRecompensa);
            
            System.out.println("✨ Você coleta materiais do Afogador e cria uma [Poção de Cura]! ✨");
            System.out.println("Item [Poção de Cura] (x1) foi adicionado ao seu inventário.");
        
        } else {
            // Se o jogador perdeu a primeira batalha, encerra o jogo.
            System.out.println("\nObrigado por jogar!");
            scanner.close();
            return; // Encerra o método main
        }
        
        System.out.println("Voltando ao rastro de sangue, você percebe que ele vai em direção ao interior da floresta.");
        aguardarEnter();
        System.out.println("Agora que está longe do rio, você consegue ver as pegadas do monstro. São grandes quase como se um celeiro caminhasse e parece que o monstro é quadrupede.");
        aguardarEnter();
        System.out.println("Sádico, quadrupede e grande. É possível descartar uma centena de monstros dessas caracteristicas.");
        aguardarEnter();
        System.out.println("Você provavelmente está enfrentando um monstro Relicto.");
        aguardarEnter();
        System.out.println("Monstros Relictos, criaturas tão antigas e poderosas que são considerados fosseis vivos. Agora a situação muda, seu oponente é muito poderoso e se deve avançar com cuidado!");
        aguardarEnter();
        System.out.println("Seguindo as pegadas é póssivel ver o rastro de destruição por onde o monstro passa, árvores derrubadas como se fossem galhos.");
        aguardarEnter();
        System.out.println("Adentrando ainda mais fundo na floresta você sente outro cheiro podrido, mas esse é muito forte!");
        aguardarEnter();
        System.out.println("Se aproximando do cheiro você encontra um bando de carniçais devorando a origem do cheiro. Um corpo de um soldado.");

        // 7. CRIAÇÃO DO INIMIGO 2
        Inimigo carnical = criarCarnical();

        // 8. LOOP DE COMBATE 
        System.out.println("\n--- A BATALHA (2) COMEÇA! ---");
        
        emCombate = true; 
        jogadorVenceu = false; 
        
        while (emCombate) {
            jogador.processarBuffs(); 
            exibirStatus(jogador, carnical); 
            int escolha = exibirOpcoesJogador(jogador);
            boolean turnoConcluido = executarAcaoJogador(escolha, jogador, carnical); 

            if (!turnoConcluido) { continue; }
            
            if (carnical.getPontosdeVida() <= 0) {
                System.out.println("\n🎉 Você derrotou " + carnical.getNome() + "! 🎉");
                emCombate = false;
                jogadorVenceu = true; 
                continue; 
            }

            aguardarEnter();

            carnical.processarBuffs(); 
            carnical.decidirAcao(jogador);
            
            if (jogador.getPontosdeVida() <= 0) {
                System.out.println("\n💀 " + jogador.getNome() + " foi derrotado... Fim de Jogo. 💀");
                emCombate = false; 
            }

            if (emCombate) { aguardarEnter(); }
        } // FIM DO COMBATE 
        
        // LOOT
        if (jogadorVenceu) {
            System.out.println("Você limpa o bando de Carniçais e arranca suas garras.");
            aguardarEnter();
            Inventario mochilaDoJogador = jogador.getInventario();
            Item pocaoAtaque = new Item("Poção de Ataque", "Aumenta ataque em 5.", Efeito.BUFF_ATAQUE, 1);
            mochilaDoJogador.adicionar(pocaoAtaque);
            System.out.println("✨ Você coleta [Garras de Carniçal] e cria uma [Poção de Ataque]! ✨");
        }
        aguardarEnter();
        System.out.println("Os carniçais estavam comendo o corpo do soldado com armadura e tudo. Hoje em dia carniçais comem qualquer coisa basicamente");
        aguardarEnter();
        System.out.println("Tentando analisar do que sobrou do homem, você percebe ele deve ser um dos soldados que tentaram caçar a criatura. Aparentemente não deu certo.");
        aguardarEnter();
        System.out.println("Olhando atentamente você percebe que o coração dele assim como a mulher de antes também foi arrancado.");
        aguardarEnter();
        System.out.println("Vasculhando os arredores você vê uma pelagem cinza com pontas marrom no chão.");
        aguardarEnter();
        System.out.println("É isso! Não é um relicto qualquer! O monstro é um Chorabash!");
        aguardarEnter();
        System.out.println("Você sabe muito bem o que é um Chorabash!");
        aguardarEnter();
        System.out.println("Uma das linhagens mais únicas dos relictos, monstros extremamente raros hoje em dia.");
        aguardarEnter();
        System.out.println("Chorabashes são monstros grandes e perigosos que se parecem com demônios, mas com chifres de carneiro e um grande olho na testa.");
        aguardarEnter();
        System.out.println("A maioria foi extinta a 1000 anos atrás durante a grande caçada bruxo aos relictos.");
        aguardarEnter();
        System.out.println("Um sobrevivente da grande caçada agora caça os moradores de Pomar Branco!");
        aguardarEnter();
        System.out.println("Sabendo disso, você deve se preparar antes de o enfretar. Lutar contra um Chorabash sem preparo é a mesmo coisa que suicídio!");
        aguardarEnter();
        System.out.println("Mas é preciso saber onde ele se esconde.");
        aguardarEnter();
        System.out.println("Seguindo os rastros você se depara com uma entrada de caverna gigante! Sem dúvidas que esse é o ninho do monstro!");
        aguardarEnter();
        System.out.println("Aparentemente o dono não está em casa, mas deve voltar em algumas horas. Você deve se preparar durante esse tempo!");
        aguardarEnter();
        System.out.println("Entrando na caverna sente um cheiro de morte avassalador. Você encherga montes e montes de esqueletos de todo tipo de ser vivo, desde humanos até animais e monstros.");
        aguardarEnter();
        System.out.println("Você sai da caverna, descança e começa a preparar seus equipamentos para o embate.");
        aguardarEnter();
        System.out.println("...");
        System.out.println("Você medita e prepara suas poções...");
        
        // 1. Cura o HP 
        jogador.curarTotalmente();
        
        // 2. Restaura o Recurso Específico 
        if (jogador instanceof Bruxo) {
            ((Bruxo) jogador).restaurarSinaisTotalmente();
        } 
        else if (jogador instanceof Mago) {
            ((Mago) jogador).descansar(); 
        } 
        else if (jogador instanceof Assassino) {
            ((Assassino) jogador).restaurarStaminaTotalmente();
        }
        
        System.out.println("...Você está pronto para a batalha.");
        aguardarEnter();
        System.out.println("Agora preparado você entra na caverna novamente e aguarda o dono retornar.");
        aguardarEnter();
        System.out.println("Algumas horas depois... (de noite)");
        aguardarEnter();
        System.out.println("De fora da caverna você escuta um grande rugido, e passos fazem a terra tremer.");
        aguardarEnter();
        System.out.println("Dois grande olhos ardendo em chamas aparecem na escuridão, não muito antes de um grande terceiro olho sobre eles se abrir.");
        aguardarEnter();
        System.out.println("Saindo da escuridão se vé o corpo da fera, uma maquina de matar gigante, com seus dois chifres de bode e três olhos sedentos por sangue.");
        aguardarEnter();
        System.out.println("Ai está ele, o Chorabash. É a sua primeira vez vendo um e talvez a ultima se não o matar agora.");
        aguardarEnter();
        System.out.println("Ele percebe sua presença e faz unica coisa esperada dele.");

        Inimigo chorabash = criarChorabash();

        // 8. LOOP DE COMBATE 
        System.out.println("\n--- A BATALHA (3) COMEÇA! ---");
        
        emCombate = true; 
        jogadorVenceu = false; 
        
        while (emCombate) {
            jogador.processarBuffs(); 
            exibirStatus(jogador, chorabash); 
            int escolha = exibirOpcoesJogador(jogador); // Corrigido na última vez
            boolean turnoConcluido = executarAcaoJogador(escolha, jogador, chorabash); 

            if (!turnoConcluido) { continue; }
            
            if (chorabash.getPontosdeVida() <= 0) {
                System.out.println("\n🎉 Você derrotou " + chorabash.getNome() + "! 🎉");
                emCombate = false;
                jogadorVenceu = true; 
                continue; 
            }

            aguardarEnter();

            chorabash.processarBuffs(); 
            chorabash.decidirAcao(jogador);
            
            if (jogador.getPontosdeVida() <= 0) {
                System.out.println("\n💀 " + jogador.getNome() + " foi derrotado... Fim de Jogo. 💀");
                emCombate = false; 
            }

            if (emCombate) { aguardarEnter(); }
        } // FIM DO COMBATE 

        // LOOT
        if (jogadorVenceu) {
            System.out.println("Você consegue derrotar a fera ancestral!");
            aguardarEnter();
            Inventario mochilaDoJogador = jogador.getInventario();
            Item pocaoAtaque = new Item("Poção de Ataque", "Aumenta ataque em 5.", Efeito.BUFF_ATAQUE, 3);
            mochilaDoJogador.adicionar(pocaoAtaque);
            System.out.println("✨ Você coleta [Cabeça de Chorabash] e cria uma [Poção de Ataque]! ✨");
        }


        System.out.println("\nObrigado por jogar!");
        scanner.close();
        
    } // FIM DO MÉTODO MAIN
    
    // ==========================================================
    // ===               MÉTODOS AUXILIARES (HELPERS)         ===
    // ==========================================================
    // (Estes métodos estão FORA do main, mas DENTRO da classe)

    /**
     * Criação do personagem, seleção de classe e nome.
     */
    private static Personagem criarPersonagem() {
        System.out.println("Escolha sua classe:");
        System.out.println("1. Bruxo (Disponível)");
        System.out.println("2. Mago (Disponível)");
        System.out.println("3. Assassino (Disponível)");
        
        int classe = 0;
        while (classe != 1 && classe != 2 && classe != 3) {
            System.out.print("Opção: ");
            classe = scanner.nextInt();
            if (classe != 1 && classe != 2 && classe != 3) {
                System.out.println("Opção inválida. Escolha 1, 2 ou 3!");
            }
        }
        scanner.nextLine(); 

        System.out.print("\nDigite o nome do seu Personagem: ");
        String nome = scanner.nextLine();

        Inventario mochila = new Inventario();
        mochila.adicionar(new Item("Poção de Cura", "Restaura 25 PV.", Efeito.CURA, 3));
        mochila.adicionar(new Item("Andorinha", "Restaura 2 Sinais.", Efeito.CURA_SINAL, 2));
        mochila.adicionar(new Item("Poção de Ataque", "Aumenta ataque em 5.", Efeito.BUFF_ATAQUE, 1)); 

        Personagem jogador = null;
        if (classe == 1) {
            jogador = new Bruxo(nome, 120, 5, 14, mochila, 7);
            System.out.println("\n" + nome + ", o Bruxo, foi criado!");
        } else if (classe == 2) {
            jogador = new Mago(nome, 80, 8, 10, mochila, 15);
            System.out.println("\n" + nome + ", o Mago, foi criado!");
        } else if (classe == 3) {
            jogador = new Assassino(nome, 90, 8, 12, mochila, 12);
            System.out.println("\n" + nome + ", o Assassino, foi criado!");
        }
        
        return jogador;
    }

   //Cria o Afogador
    private static Inimigo criarAfogador() {
        Inventario mochilaAfogador = new Inventario();
        Inimigo inimigo = new Inimigo("Afogador", 50, 4, 12, mochilaAfogador);
        
        System.out.println("\nVocê chega perto do rio nevoluso...");
        System.out.println("De repente, um " + inimigo.getNome() + " pula das águas!");
        return inimigo;
    }

   //Cria os carniçais
    private static Inimigo criarCarnical() {
        Inventario mochilaCarnical = new Inventario(); 
        Inimigo inimigo2 = new Inimigo("Bando de Carniçais", 80, 4, 12, mochilaCarnical);
        System.out.println("\nOs carniçais notam sua presença!");
        System.out.println("O " + inimigo2.getNome() + " avança em sua direção!");
        return inimigo2;
    }

    private static Inimigo criarChorabash() {
        Inventario mochilaChorabash = new Inventario(); 
        Inimigo inimigo3 = new Inimigo("Chorabash", 140, 6, 14, mochilaChorabash);
        System.out.println("\nO Chorabash Ruge!");
        System.out.println(inimigo3.getNome() + " avança em sua direção!");
        return inimigo3;
    }


    /**
     * Mostra o HP do jogador e do inimigo.
     */
    private static void exibirStatus(Personagem jogador, Inimigo inimigo) {
        System.out.println("\n========================================");
        System.out.print("👤 " + jogador.getNome() + " | HP: " + jogador.getPontosdeVida()+" | Defesa: " + jogador.getDefesa());
        
        if (jogador instanceof Bruxo) {
            Bruxo bruxo = (Bruxo) jogador;
            System.out.print(" | Sinais: " + bruxo.getPontosDeSinal() + "/8");
        } else if (jogador instanceof Mago) {
            Mago mago = (Mago) jogador;
            System.out.print(" | Mana: " + mago.getMana() + "/100");
        } else if (jogador instanceof Assassino) {
            Assassino assassino = (Assassino) jogador;
            System.out.print(" | Stamina: " + assassino.getStamina());
        }
        
        System.out.println("\n----------------------------------------");
        System.out.println("👹 " + inimigo.getNome() + " | HP: " + inimigo.getPontosdeVida()+" | Defesa: " + inimigo.getDefesa());
        System.out.println("========================================");
    }

    /**
     * Mostra as opções de ação do jogador e retorna a escolha.
     */
    private static int exibirOpcoesJogador(Personagem jogador) {
        System.out.println("É seu turno. O que fazer?");
        System.out.println("1. Atacar"); // Ataque base

        if (jogador instanceof Bruxo) {
            System.out.println("2. Lançar Igni (Custo: 2 Sinais)");
            System.out.println("3. Lançar Aard (Custo: 1 Sinal)");
            System.out.println("4. Lançar Quen (Custo: 2 Sinais)");
            System.out.println("5. Lançar Axii (Custo: 3 Sinais)"); 
            System.out.println("6. Usar Item");                     
        } else if (jogador instanceof Mago) {
            System.out.println("2. Espinhos Vermelhos Demoníacos (Custo: 20 Mana)");
            System.out.println("3. Relâmpago de Plasma (Custo: 40 Mana)");
            System.out.println("4. Trovão Aurora (Custo: 60 Mana)");
            System.out.println("5. Explosão da Coroa Solar (Custo: 80 Mana)");
            System.out.println("6. Ciclo das Seis Existências (Custo: 100 Mana)");
            System.out.println("7. Usar Item");
        } else if (jogador instanceof Assassino) {
            System.out.println("2. Lançar Facas (Custo: 1 Stamina)");
            System.out.println("3. Atirar Besta (Custo: 2 Stamina)");
            System.out.println("4. Ataque com Fumaça (Custo: 3 Stamina)");
            System.out.println("5. Estocada no Pescoço (Custo: 4 Stamina)");
            System.out.println("6. Usar Item");
        } else {
            System.out.println("2. Usar Item"); 
        }

        System.out.print("Escolha: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); 
        return escolha;
    }

    /**
     * Executa a ação do jogador.
     * @return 'true' se o turno foi concluído, 'false' se o jogador cancelou a ação.
     */
    private static boolean executarAcaoJogador(int escolha, Personagem jogador, Inimigo inimigo) {
        
        // --- LÓGICA DO BRUXO ---
        if (jogador instanceof Bruxo) {
            Bruxo bruxo = (Bruxo) jogador;
            switch (escolha) {
                case 1: bruxo.atacar(inimigo); return true;
                case 2: bruxo.lancarIgni(inimigo); return true;
                case 3: bruxo.lancarAard(inimigo); return true;
                case 4: bruxo.lancarQuen(); return true; 
                case 5: bruxo.lancarAxii(inimigo); return true; 
                case 6: return lidarComInventario(jogador); // Chama o método de inventário
                default:
                    System.out.println("Opção inválida! Você gaguejou e perdeu o turno.");
                    return true;
            }
        // --- LÓGICA DO MAGO ---
        } else if (jogador instanceof Mago) {
            Mago mago = (Mago) jogador;
            switch (escolha) {
                case 1: mago.atacar(inimigo); return true;
                case 2: mago.EspinhosVermelhosDemoniacos(inimigo); return true;
                case 3: mago.RelampagoDePlasma(inimigo); return true;
                case 4: mago.TrovaoAurora(inimigo); return true;
                case 5: mago.ExplosaoDaCoroaSolar(inimigo); return true;
                case 6: mago.CicloDasSeisExistencias(inimigo); return true;
                case 7: return lidarComInventario(jogador); // Chama o método de inventário
                default:
                    System.out.println("Opção inválida! Você gaguejou e perdeu o turno.");
                    return true;
            }
        // --- LÓGICA DO ASSASSINO ---
        } else if (jogador instanceof Assassino) {
            Assassino assassino = (Assassino) jogador;
            switch (escolha) {
                case 1: assassino.atacar(inimigo); return true;
                case 2: assassino.LancarFacas(inimigo); return true;
                case 3: assassino.AtirarBestaLaminadoCaos(inimigo); return true;
                case 4: assassino.AtaqueComBombaDeFumaca(inimigo); return true;
                case 5: assassino.EstocadaPescocoLaminadoCaos(inimigo); return true;
                case 6: return lidarComInventario(jogador); // Chama o método de inventário
                default:
                    System.out.println("Opção inválida! Você gaguejou e perdeu o turno.");
                    return true;
            }
        // --- LÓGICA PADRÃO ---
        } else { 
            switch (escolha) {
                case 1: jogador.atacar(inimigo); return true;
                case 2: return lidarComInventario(jogador);
                default:
                    System.out.println("Opção inválida! Você gaguejou e perdeu o turno.");
                    return true;
            }
        }
    } // <-- CORREÇÃO: Faltava esta chave para fechar o método

    /**
     * Método centralizado para lidar com o menu do inventário.
     */
    private static boolean lidarComInventario(Personagem jogador) {
        Inventario mochila = jogador.getInventario();
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
            return true; // Turno concluído
        } else {
            System.out.println("Número de item inválido!");
            return false; 
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
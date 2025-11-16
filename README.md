# Projeto RPG - Caçador de Monstros

Executar o arquivo MAIN.java inicia o jogo (OBRIGATÓRIO TER TODOS OS ARQUIVOS!!!)

## 🎮 Classes Jogáveis:

### 🧙‍♂️ Bruxo
Um guerreiro versátil tanto no corpo a corpo quanto com magias simples.
- **Igni**: Causa dano de fogo (Custo: 2 Sinais)
- **Aard**: Causa dano de vento (Custo: 1 Sinal)
- **Quen**: Protege contra ataques (Custo: 2 Sinais)
- **Axii**: Causa efeitos negativos no inimigo (Custo: 3 Sinais)

### 🗡️ Assassino
Uma classe focada em dano físico que usa stamina para executar habilidades:
- **Lançar Facas**: Causa dano leve com um custo muito baixo de stamina (1 Stamina)
- **Atirar Besta**: Um tiro de besta com dano moderado (2 Stamina)
- **Ataque com Bomba de Fumaça**: Usa fumaça para um ataque surpresa e forte (3 Stamina)
- **Estocada no Pescoço**: Um golpe devastador que causa o maior bônus de dano (4 Stamina)

### 🔮 Mago
Uma classe poderosa especializada em magias elementais que consome mana:
- **Espinhos Vermelhos Demoníacos**: Magia básica de natureza (Custo: 20 Mana)
- **Relâmpago de Plasma**: Ataque elétrico com bônus de crítico (Custo: 40 Mana)
- **Trovão Aurora**: Magia de gelo que causa debuff no inimigo (Custo: 60 Mana)
- **Explosão da Coroa Solar**: Dano massivo de fogo sem teste de acerto (Custo: 80 Mana)
- **Ciclo das Seis Existências**: Magia suprema com dano extremo e debuff severo (Custo: 100 Mana)
- **Meditar**: Recupera instantaneamente toda a mana (100/100) - ação estratégica crucial

## 🎒 Sistema de Inventário Avançado

### 📦 Características Principais:
- **Armazenamento Inteligente**: Itens são organizados automaticamente por nome e efeito
- **Sistema de Chaves Únicas**: Cada item é identificado por "nome_efeito" (ex: "poção_cura")
- **Agrupamento Automático**: Itens iguais são acumulados em uma única entrada
- **Busca Avançada**: Filtre itens por nome ou tipo de efeito
- **Ordenação**: Lista organizada alfabeticamente para fácil localização

### 🏷️ Tipos de Itens Disponíveis:
- **Poção de Cura**: Restaura 25 Pontos de Vida
- **Poção de Cura Superior**: Restaura 50 Pontos de Vida  
- **Poção de Ataque**: Aumenta ataque em 3
- **Poção de Defesa**: Aumenta defesa em 5
- **Andorinha**: Restaura 4 Sinais (apenas para Bruxo)

### ⚙️ Funcionalidades do Inventário:
- `adicionar(Item)`: Adiciona itens ao inventário (agrupa automaticamente)
- `remover()`: Remove itens por nome ou nome+efeito
- `listarOrdenado()`: Retorna lista organizada de itens
- `getItensPorNome()`: Busca itens específicos
- `getItensPorEfeito()`: Filtra por tipo de efeito
- `transferirItens()`: Transfere itens entre inventários
- `contemQuantidade()`: Verifica se possui itens suficientes

## 🎯 Como Jogar:
1. Execute `Main.java`
2. Escolha sua classe preferida
3. Siga a narrativa e tome decisões
4. Use habilidades especiais durante o combate
5. Gerencie seu inventário estrategicamente
6. Derrote monstros e complete missões

## ⚠️ Requisitos:
- Java JDK 8 ou superior
- Todos os arquivos .java devem estar no mesmo diretório

---

*Desenvolvido como projeto acadêmico de programação orientada a objetos*

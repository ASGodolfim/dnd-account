# DnD Account

Será um programa para Criar contas e guardar seus personagens de dnd

Você poderá guardar personagens dentro da conta e procurar por eles usando o id da conta + id do personagem ou nome do personagem.

Utilizando o Spring boot para a conexão com o MySQL e Postman para implementação de dados e testes de requisição
Criptografia para a senha com o pbkd2 e geração de token.

------------------------------------------------------------------------------------------------------------------------

CRUDS:

- Usuario

1. Criar Conta

2. Achar Conta pelo usuario

3. Modificar conta

4. Achar todos os personagens de uma conta pelo usuario

- Personagem

1. Criar Personagem

2. Modificar Personagem

3. Achar Personagem por nome e usuario

4. Achar um Personagem pelo id

5. Achar Todos os Personagens

6. Deletar um personagem

------------------------------------------------------------------------------------------------------------------------

Lista dos elementos da Conte e Personagem:
(passível a mudança)

 - Conta:

1. Usuário (único) (String)

2. Senha (String)

3. Nome Completo (String)

4. Email (unico)(String)

5. Endereço (String)

6. Idade (Integer)

                                    --------------------------------------------

 - Personagens:

1. Nome (String)

2. Força (Integer)

3. Constituição (Integer)

4. Destreza (Integer)

5. Sabedoria (Integer)

6. Inteligência (Integer)

7. Carisma (integer)

8. Nivel do Personagem (Integer) (Nivel Mínimo 1 e máximo 20)

9. Classe (String) (Lista com as classes possíveis)

10. Sub-Classe (String) (Lista Com Sub-Classes Possíveis)

11. Nivel da Classe (Integer) (Nivel mínimo 1 e máximo 20 somando com multi-classe)

12. Multi-Classe (Bolean) (Nivel mínimo 2)

13. Classe 2 (String) (Lista com as classes possíveis)

14. SubClasse2 (String) (Lista Com Sub-Classes Possíveis)

15. Vida Máxima (Integer) (baseado na classe calculo automático)

16. Classe de Armadura (Integer) 

17. Ouro (Integer)

18. Armadura (String)

19. Arma (String)

20. Tesouro (String)

------------------------------------------------------------------------------------------------------------------------

Lista de Classes e Sub Classes Existentes:

- Artificer


1. Alchemist

2. Armorer

3. Artillerist

4. Battle Smith



- Barbarian


1. Berserker

2. Storm Herald

3. Totem Warriror

4. Wild Magic



- Bard


1. Lore

2. Swords

3. Valor

4. Glamour



- Cleric


1. Life

2. Twilight

3. Grave

4. Tempest



- Druid


1. Moon

2. Dreams

3. Spores

4. Stars



- Fighter


1. Battle Master

2. Echo Knight

3. Rune Knight

4. Samurai



- Monk


1. Astral Self

2. Drunken Master

3. Four Elements

4. Open Hand



- Paladin


1. Ancients

2. Conquest

3. Glory



4. Oathbreaker


- Ranger

1. Beast Master

2. Gloom Stalker

3. Hunter

4. Swarmkeeper



- Rogue


1. Arcane Trickster

2. Assassin

3. Mastermind

4. Phantom



- Sorcerer


1. Draconic Bloodline

2. Divine Soul

3. Shadow Magic

4. Storm Sorcery



- Warlock


1. Archfey

2. Fiend

3. Hexblade

4. Undead



- Wizard


1. Bladesinging

2. Graviturgy

3. Scribes

4. War Magic
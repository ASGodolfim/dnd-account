# DnD Account

Será um programa para Criar contas e guardar seus personagens de dnd

Você poderá guardar personagens dentro da conta e procurar por eles usando o id da conta + id do personagem ou nome do personagem.

Utilizando o Spring boot para a conexão com o MySQL e Postman para implementação de dados e testes de requisição
Criptografia para a senha com o pbkd2 e geração de token.

 - Conta:
 terá as seguintes informações (passível a mudança)

1. Usuário (único) (String)

2. Senha (String)

3. Nome Completo (String)

4. Email (unico)(String)

5. Endereço (String)

6. Idade (Integer)

 - Personagens:
 terá as seguintes informações (passível a mudança)

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

19. Arma (<String>)

20. Tesouro (<String>)
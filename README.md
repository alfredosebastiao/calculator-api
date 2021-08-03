# Calculator-API
Projecto baseado em Maven .

A API foi Desenhada com base no framework da Linguagem Java, Spring Boot, na versão 2.5.3, sendo esta a versão mais estável, de entre as versões mais recentes, actualmente.
A API fornece as operações básicas de uma calculadora (soma, subtracção, multiplicação e divisão) através de endpoints especificados que recebem dois parâmetros **a** e **b**, possuindo suporte para *arbitrary precision signed decimal numbers*.

A API possui dois módulos, cuja comunicação entre os mesmos é feita baseando-se em RabbitMQ e Spring AMQP para a gestão da fila de tratamento de requisições efectuadas à API.

Na mesma API, é feito o uso de logback-access para logging do tráfego HTTP, é atribuído a cada pedido REST individual, um identificador único e o mesmo é enviado durante a comunicação com o cliente, através de um response header, por fim, através do MDC este identificador é incluso  em cada linha de logging que diz respeito a um pedido HTTP em ambos os módulos existentes na Aplicação.

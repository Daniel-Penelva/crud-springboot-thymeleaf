# Anotação `@Controller`

A anotação `@Controller` é uma anotação do Spring Framework usada para marcar uma classe como um controlador da camada de apresentação em um aplicativo da web. Os controladores desempenham um papel fundamental em estruturas de desenvolvimento da web baseadas em Spring, como o Spring MVC (Model-View-Controller).

Características e funções associadas à anotação `@Controller`:

1. **Tratamento de Requisições HTTP:** As classes anotadas com `@Controller` são responsáveis por tratar as requisições HTTP dos clientes da aplicação da web. Eles definem métodos que são chamados quando um URL específico é acessado, e esses métodos lidam com a lógica de processamento associada a essa solicitação.

2. **Mapeamento de URLs:** A anotação `@Controller` frequentemente trabalha em conjunto com outras anotações, como `@RequestMapping`, para mapear URLs específicos para métodos de controle. Por exemplo, você pode usar `@RequestMapping("/minharota")` antes de um método, indicando que esse método deve ser executado quando a URL "/minharota" for acessada.

3. **Tratamento de Modelos e Visualizações:** Os métodos de controle geralmente retornam um objeto `ModelAndView` que contém dados do modelo a ser exibido na página e a visualização (template) que deve ser usada para renderizar a página. O Thymeleaf é comumente usado em conjunto com controladores Spring para gerar páginas HTML.

4. **Gestão do Ciclo de Vida da Solicitação:** Os controladores gerenciam o ciclo de vida da solicitação, lidando com a requisição, processando-a e retornando uma resposta. Isso permite que você implemente a lógica de negócios da aplicação e controle o fluxo das páginas da web.

5. **Integração com Outros Componentes:** Os controladores geralmente se integram com outros componentes do Spring, como serviços, repositórios e componentes de segurança, para buscar dados, aplicar lógica de negócios e muito mais.

# Interface `Model`

A interface `Model` é um componente importante dentro do ecossistema do Spring Framework, especialmente em aplicativos Spring MVC (Model-View-Controller) que lidam com a criação de páginas da web. A `Model` é uma interface que permite que os controladores forneçam dados que serão exibidos nas visualizações (páginas) de um aplicativo.

Principais pontos a serem conhecidos:

1. **Interface Model**: A `Model` é uma interface que faz parte do módulo Spring Web. Ela está localizada no pacote `org.springframework.ui` e pode ser implementada por diferentes classes internas do Spring, como `ModelMap` e `ExtendedModelMap`, para fornecer funcionalidades específicas.

2. **Objeto de Modelo**: Em um controlador Spring, você pode criar um objeto `Model` como um parâmetro de um método de manipulação de solicitações. Esse objeto é usado para adicionar atributos que representam dados a serem enviados para a visualização.

   Exemplo simples:

   ```java
   @GetMapping("/exemplo")
   public String meuMetodo(Model model) {
       model.addAttribute("nome", "João");
       return "minha-pagina";
   }
   ```

   Neste exemplo, o atributo "nome" é adicionado ao modelo e pode ser acessado na visualização associada à página "minha-pagina".

3. **Compartilhamento de Dados**: A interface `Model` facilita o compartilhamento de dados entre controladores e visualizações. Os atributos adicionados ao modelo podem ser referenciados nas páginas da web, permitindo que você exiba informações dinâmicas.

4. **Integração com Thymeleaf e Outros Templates**: O uso de `Model` é comum em combinação com mecanismos de templates como o Thymeleaf. Isso permite que você insira os dados do modelo diretamente nas páginas da web usando expressões, tornando a construção de páginas dinâmicas mais simples.

5. **Testabilidade**: A classe `Model` é útil em testes de controladores, pois permite verificar se os atributos esperados estão sendo adicionados ao modelo antes de serem enviados para a visualização.

6. **Não Específico da Implementação**: A interface `Model` não é vinculada a nenhuma tecnologia específica de visualização. Portanto, você pode usá-la com várias tecnologias de templates, incluindo Thymeleaf, JSP, FreeMarker, entre outras.

Em resumo, a interface `Model` é uma parte essencial do Spring MVC e desempenha um papel importante na passagem de dados do controlador para a camada de visualização em aplicativos da web Spring. Ela permite que você crie páginas dinâmicas, adicionando atributos que podem ser renderizados nas visualizações, facilitando a criação de aplicativos da web ricos em funcionalidades.


# Passo a Passo do método de Controle novoEstudante()

```java
@GetMapping("/novo")
public String novoEstudante(Model model){
    Estudante estudante = new Estudante();
    model.addAttribute("novoEstudante", estudante);
    return "/novo-estudante";
}
```

- `@GetMapping("/novo")`: Esta anotação mapeia solicitações HTTP GET para a URL "/novo" para este método. Isso significa que quando acessa a URL "/novo" em um navegador, este método será chamado para processar a solicitação.

- `public String novoEstudante(Model model)`: Este método tem um parâmetro `Model model`, que é usado para passar dados do controlador para a visualização (template). O tipo `Model` é usado para adicionar atributos que serão usados na visualização. Neste caso, o método retorna uma `String`, que é o nome da visualização que deve ser renderizada.

- `Estudante estudante = new Estudante();`: Aqui, um novo objeto da classe `Estudante` é criado. Onde `Estudante` é uma classe que representa informações de um estudante.

- `model.addAttribute("novoEstudante", estudante);`: Este código adiciona o objeto `estudante` como um atributo chamado "novoEstudante" ao modelo (`Model`). Isso torna o objeto `estudante` acessível na visualização, para que você possa exibir as informações do estudante na página da web.

- `return "/novo-estudante";`: Esta linha retorna uma `String` que é o nome da visualização (template) que é usada para renderizar a página. Neste caso, a visualização esperada é chamada "/novo-estudante". O framework Spring irá então procurar um arquivo de modelo Thymeleaf chamado "novo-estudante.html" para renderizar a página.

Em resumo, este método é responsável por lidar com solicitações GET para a URL "/novo" e renderizar uma página chamada "novo-estudante.html". Ele também cria um objeto `Estudante` vazio e o torna disponível na visualização para preenchimento de informações relacionadas a um novo estudante.

## Bom Saber

No trecho de código `model.addAttribute("novoEstudante", estudante);` está adicionando um atributo chamado "novoEstudante" ao objeto `model`. Esse atributo (ou apelido) é associado a um objeto `Estudante` chamado `estudante`. O "novoEstudante" é um identificador que vai ser usado na página Thymeleaf para acessar o objeto `estudante`.

Aqui está como essa associação funciona com o formulário e os campos de entrada HTML:

1. No formulário Thymeleaf:

   ```html
   <form action="" th:object="${novoEstudante}" method="post">
   ```

   Neste trecho, `th:object="${novoEstudante}"` está vinculando o objeto do formulário ao atributo "novoEstudante" que foi adicionado ao `model`. Isso significa que os campos de entrada dentro deste formulário estão relacionados ao objeto `novoEstudante` (que é um objeto `Estudante`).

2. Campos de entrada HTML:

   ```html
   <input type="text" class="form-control" id="nome" placeholder="Insira seu nome" th:field="*{nome}"/>
   <input type="number" class="form-control" id="idade" th:field="*{idade}"/>
   ```

   Nesses campos de entrada, `th:field="*{nome}"` e `th:field="*{idade}"` estão associando os campos do formulário aos campos `nome` e `idade` do objeto `Estudante`. O Thymeleaf usa a expressão `*{nome}` para indicar que esses campos estão vinculados ao objeto `novoEstudante` (ou seja, ao objeto `Estudante`).

Assim, quando o formulário é enviado, o Spring Framework e o Thymeleaf mapeiam automaticamente os valores dos campos de entrada para as propriedades do objeto `novoEstudante`, com base nos nomes dos campos e das propriedades do objeto. Isso simplifica o processo de obtenção dos dados do formulário no seu controlador, pois os valores do formulário são automaticamente vinculados ao objeto `Estudante` associado ao atributo "novoEstudante".

# Anotação `@ModelAttribute`

A anotação `@ModelAttribute` é usada em controladores Spring para vincular métodos de controle a um modelo, permitindo que você compartilhe dados com a visualização (normalmente uma página da Web) ou para outros métodos do controlador. Ela é usada para adicionar atributos ao modelo que estarão disponíveis para a visualização durante o processamento da solicitação.

Informações importantes sobre `@ModelAttribute`:

1. **Adição de Atributos ao Modelo**: Quando você anota um método com `@ModelAttribute`, o valor retornado por esse método é adicionado ao modelo. O método pode retornar um objeto, um Map, ou um valor qualquer, e esse valor estará disponível na página da web para preencher campos de formulário, exibir informações ou qualquer outra finalidade necessária.

2. **Nome do Atributo**: O nome do atributo no modelo é derivado do nome do método que possui a anotação `@ModelAttribute`. Por exemplo, se você tem um método anotado como `@ModelAttribute("meuAtributo")`, o nome do atributo no modelo será "meuAtributo". Se você não especificar um nome, o Spring usará o nome do método (com a primeira letra em minúsculas) como o nome do atributo.

3. **Exposição Automática**: A anotação `@ModelAttribute` também pode ser usada para indicar que um determinado objeto deve ser exposto automaticamente a todas as páginas da web que o utilizem. Por exemplo, se você tem um método anotado com `@ModelAttribute` no controlador e uma página da web usa esse modelo, o objeto retornado por esse método estará disponível na página.

`@ModelAttribute` é uma anotação poderosa e flexível que é comumente usada em projetos Spring para passar dados do controlador para a visualização e vice-versa. Isso facilita a criação de páginas da web dinâmicas que exibem informações diretamente de objetos Java.

# Classe `RedirectAttributes`

A classe `RedirectAttributes` é parte do framework Spring MVC e é usada para passar atributos entre solicitações ao redirecionar o usuário para uma nova URL. Ela é frequentemente usada quando você deseja redirecionar o usuário após a conclusão de uma ação e, ao mesmo tempo, transmitir algumas informações, geralmente mensagens ou dados, para a próxima solicitação. Isso é especialmente útil para exibir mensagens de sucesso, validação de erros ou quaisquer outras informações relevantes após a execução de uma ação.

O que pode fazer com o `RedirectAttributes`:

1. **Adicionar atributos**: Você pode usar o método `addAttribute()` para adicionar atributos que serão transmitidos para a próxima solicitação. Por exemplo, você pode adicionar uma mensagem de sucesso após a criação de um novo registro.

   ```java
   redirectAttributes.addAttribute("mensagem", "Estudante criado com sucesso!");
   ```

2. **Adicionar atributos flash**: A classe `RedirectAttributes` possui um método chamado `addFlashAttribute()` que permite adicionar atributos "flash". A principal diferença entre atributos normais e atributos flash é que os atributos flash sobrevivem apenas uma solicitação. Eles são geralmente usados para transmitir informações de uma solicitação para a próxima (após o redirecionamento) e, em seguida, são automaticamente removidos.

   ```java
   redirectAttributes.addFlashAttribute("mensagem", "Estudante criado com sucesso!");
   ```

3. **Redirecionar**: Você normalmente usará `RedirectAttributes` com o método `redirect:/algumaURL` para redirecionar o usuário para uma nova página após a conclusão da ação.

   ```java
   return "redirect:/outraURL";
   ```

4. **Recuperar atributos após o redirecionamento**: Na próxima solicitação, você pode recuperar os atributos usando o modelo ou diretamente da solicitação. Isso permite que você exiba informações relevantes na nova página. Por exemplo, você pode acessar a mensagem de sucesso que adicionou anteriormente.

   ```java
   @GetMapping("/outraURL")
   public String outraPagina(Model model) {
       String mensagem = (String) model.getAttribute("mensagem");
       // Faça algo com a mensagem na sua página
       return "pagina";
   }
   ```

No contexto de uma aplicação Spring MVC, o `RedirectAttributes` é uma maneira eficaz de passar informações entre ações e páginas, especialmente após a execução de operações como inserção, atualização ou exclusão de registros no banco de dados. Isso permite que os usuários vejam mensagens informativas ou de sucesso, além de manter a integridade da URL e garantir uma experiência de usuário limpa.

# Passo a Passo do método de Controle gravarEstudante()

```java
@PostMapping("/gravarEstudante")
public String gravarEstudante(@ModelAttribute("novoEstudante") Estudante estudante,
        RedirectAttributes redirectAttributes) {
    
    estudanteService.criarEstudante(estudante);

    redirectAttributes.addFlashAttribute("mensagem", "Estudante salvo com sucesso!");
    
    return "redirect:/novo";
}
```

1. `@PostMapping("/gravarEstudante")`: Esta anotação mapeia a solicitação HTTP POST para a URL `/gravarEstudante` a este método do controlador. Isso significa que quando alguém envia um formulário ou faz uma solicitação POST para essa URL, este método será chamado para processar a solicitação.

2. `public String gravarEstudante(@ModelAttribute("novoEstudante") Estudante estudante, RedirectAttributes redirectAttributes)`: Este é o método que lida com a solicitação POST. Aqui estão os parâmetros e o que eles fazem:
   - `@ModelAttribute("novoEstudante") Estudante estudante`: Este parâmetro indica que está esperando que os dados do formulário sejam vinculados a um objeto `Estudante`. O `@ModelAttribute` é usado para vincular os campos do formulário com os campos do objeto `Estudante`. O valor `"novoEstudante"` especifica o nome do modelo usado no formulário para referenciar este objeto.
   - `RedirectAttributes redirectAttributes`: Isso é usado para passar atributos entre solicitações ao redirecionar o usuário para uma nova URL. Ele permite que você adicione atributos para transmiti-los para a próxima solicitação após o redirecionamento.

3. `estudanteService.criarEstudante(estudante)`: Esta linha chama um serviço (presumivelmente `estudanteService`) para criar um novo estudante. Os dados do estudante são extraídos do objeto `estudante` que foi vinculado ao formulário.

4. `redirectAttributes.addFlashAttribute("mensagem", "Estudante salvo com sucesso!")`: Aqui, está usando o `RedirectAttributes` para adicionar um atributo "flash" chamado "mensagem". Esse atributo contém uma mensagem que será exibida na próxima solicitação, em uma página que o usuário será redirecionado após a criação bem-sucedida do estudante. A principal diferença entre um atributo flash e um atributo normal é que os atributos flash são automaticamente removidos após a próxima solicitação. Portanto, a mensagem só será exibida uma vez após o redirecionamento.

5. `return "redirect:/novo"`: Finalmente, esta linha redireciona o usuário para a URL `/novo` após a conclusão bem-sucedida da criação do estudante. Isso é feito usando o `"redirect:"` antes da URL, o que instrui o Spring MVC a redirecionar o usuário para a página correspondente.

No geral, esse método é usado para processar a criação de um novo estudante, exibe uma mensagem de sucesso após o redirecionamento para a próxima página e usa o atributo flash para transmitir a mensagem entre as solicitações.
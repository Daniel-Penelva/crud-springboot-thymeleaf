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

A classe `RedirectAttributes` é uma parte importante do Spring Framework, frequentemente usada em aplicações da web para passar informações de um controlador para outro, principalmente ao redirecionar o usuário para diferentes páginas ou URLs após a conclusão de alguma ação.

Principais pontos relacionados à classe `RedirectAttributes`:

1. **Propósito**: O principal objetivo do `RedirectAttributes` é permitir que você envie atributos (dados) de um controlador para outro ao redirecionar o usuário para uma nova página ou URL. Isso é útil quando você deseja passar mensagens de sucesso, informações de status ou dados relacionados ao resultado de uma operação (como uma confirmação de que um registro foi criado com sucesso) de um controlador para outro.

2. **Redirecionamento**: Em uma aplicação da web, muitas vezes você redireciona o usuário para diferentes páginas ou URLs em resposta a ações (por exemplo, após um envio de formulário bem-sucedido). O redirecionamento normalmente envolve o envio de uma resposta HTTP com um status 3xx e um cabeçalho "Location" para o navegador, que, por sua vez, solicita a nova página. O `RedirectAttributes` ajuda a passar informações durante esse processo.

3. **Uso com `redirect:`**: Ao usar a classe `RedirectAttributes`, você pode incluir atributos que deseja passar para a próxima solicitação de redirecionamento. Isso é frequentemente feito com a notação `"redirect:"` no valor do `return` em um método do controlador.

4. **Exemplo simples de Uso**:

   ```java
   @PostMapping("/salvar")
   public String salvarAlgo(RedirectAttributes redirectAttributes) {
       // Lógica para salvar algo
       redirectAttributes.addFlashAttribute("mensagem", "Operação realizada com sucesso!");
       return "redirect:/outrapagina";
   }
   ```

   Neste exemplo, após a operação de salvar, a mensagem "Operação realizada com sucesso!" é adicionada como um atributo flash. A notação `"redirect:/outrapagina"` indica que o usuário será redirecionado para a página `/outrapagina`.

5. **Flash Attributes**: A classe `RedirectAttributes` suporta o uso de atributos "flash". A diferença entre atributos flash e regulares é que os flash attributes são armazenados temporariamente e estão disponíveis apenas para a próxima solicitação. Depois disso, eles são automaticamente removidos. Isso é útil para exibir informações de sucesso ou mensagens de erro após um redirecionamento, sem a necessidade de usar sessões ou cookies.

6. **Outros Métodos**: Além de `addFlashAttribute`, a classe `RedirectAttributes` oferece outros métodos para trabalhar com atributos, como `addAttribute` (para atributos regulares) e `getFlashAttributes` (para obter atributos flash).

Em resumo, `RedirectAttributes` é uma classe essencial para passar informações entre controladores ao redirecionar o usuário, especialmente quando você deseja comunicar resultados ou mensagens entre diferentes partes de sua aplicação da web.


# Interface `BindingResult`

O `BindingResult` é uma interface do Spring Framework que desempenha um papel fundamental na validação e no processamento de erros em operações de ligação (binding) entre dados do formulário web e objetos Java, frequentemente usados em aplicativos da web. A principal função do `BindingResult` é armazenar informações sobre erros de validação ou conversão que ocorrem durante o processo de ligação entre os dados do formulário e os objetos de domínio.

Aspectos importantes sobre a classe `BindingResult`:

1. **Validação de Dados**:
   - O `BindingResult` é frequentemente usado em conjunto com a anotação `@Valid` em parâmetros de métodos em controladores Spring, como os utilizados em operações de criação ou atualização de recursos por meio de formulários web.
   - Ele é responsável por armazenar informações sobre os erros de validação que ocorrem durante a validação dos dados fornecidos pelos usuários.

2. **Tratamento de Erros**:
   - Quando os dados de entrada não atendem às regras de validação definidas nas anotações, o `BindingResult` armazena esses erros.
   - O controlador pode verificar o `BindingResult` para determinar se ocorreram erros de validação.

3. **Uso em Redirecionamento**:
   - O `BindingResult` é frequentemente usado para redirecionar o usuário de volta ao formulário quando ocorrem erros de validação.
   - Isso permite que os erros sejam apresentados ao usuário para correção.

4. **Integração com Thymeleaf e Outros Motores de Modelagem**:
   - Comumente, o `BindingResult` é usado em conjunto com motores de modelagem, como o Thymeleaf, para exibir mensagens de erro em locais apropriados nos formulários web.

5. **Métodos Úteis**:
   - A interface `BindingResult` define métodos úteis para acessar informações sobre erros, como `hasErrors()` (para verificar se há erros), `getFieldErrors()` (para obter erros de campos específicos) e `getGlobalErrors()` (para obter erros globais que não estão associados a campos específicos).

6. **Uso em Erros de Conversão**:
   - Além de erros de validação, o `BindingResult` também lida com erros de conversão de tipos de dados, como tentar converter uma string em um número inteiro.

7. **Personalização de Mensagens de Erro**:
   - O `BindingResult` permite a personalização das mensagens de erro exibidas aos usuários. As mensagens de erro podem ser especificadas nas anotações de validação no nível das classes de domínio.

Em resumo, o `BindingResult` é uma ferramenta importante para processar validações e erros de conversão de dados em aplicativos da web Spring. Ele desempenha um papel crucial ao garantir que os dados fornecidos pelos usuários atendam aos critérios definidos e permite ao aplicativo fornecer feedback adequado aos usuários quando ocorrem erros de validação ou conversão.


# Anotação `@Valid`

A anotação `@Valid` é uma anotação importante em aplicações Spring que trabalham com validação de dados. Essa anotação é usada principalmente em combinação com o framework de validação do Java Bean Validation (geralmente usando anotações como `@NotNull`, `@Size`, `@Pattern`, entre outras) para validar objetos em classes controladoras (controllers) ou serviços.

Conceitos-chave relacionados à anotação `@Valid`:

1. **Validação de Dados**: A validação de dados é um processo crítico em qualquer aplicação para garantir que os dados inseridos ou manipulados estejam em conformidade com as regras e requisitos definidos. Isso ajuda a garantir a integridade e a qualidade dos dados.

2. **Java Bean Validation**: É uma especificação Java EE que define um conjunto de anotações (como `@NotNull`, `@Size`, `@Pattern`, etc.) que podem ser usadas para marcar propriedades de classes Java (Java Beans) para validação de dados.

3. **Integração com Spring**: O Spring Framework suporta a validação de dados usando a especificação Java Bean Validation. Você pode usar as anotações de validação em seus objetos de domínio e, em seguida, usar a anotação `@Valid` para acionar a validação desses objetos em suas classes controladoras.

4. **Uso da Anotação `@Valid`**: Quando é aplicado a anotação `@Valid` a um parâmetro de método em um controlador, o Spring irá disparar a validação dos campos anotados em um objeto, com base nas anotações Bean Validation, antes de executar o método do controlador. Se a validação falhar, o Spring pode retornar um erro apropriado, como uma resposta HTTP 400 Bad Request, indicando que os dados de entrada são inválidos.

O uso de `@Valid` simplifica a lógica de validação nos controladores, permitindo que você se concentre na lógica de negócios e mantendo as regras de validação de dados separadas dos controladores.


# Método `hasErrors()`

O método `hasErrors()` faz parte da funcionalidade de validação fornecida pelo Spring Framework e é usado para verificar se há erros de validação em um objeto. Ele é frequentemente usado em conjunto com objetos como `BindingResult` ou `Errors` após a validação ter sido executada, para determinar se ocorreram erros de validação.

Como ele funciona:

1. Após a validação de um objeto, como um objeto de formulário, o Spring Framework preenche um objeto `BindingResult` (ou `Errors`) com informações sobre os erros de validação.

2. O método `hasErrors()` é chamado em um objeto `BindingResult` para verificar se há erros. Se houver erros, ele retorna `true`, indicando que ocorreram erros de validação. Caso contrário, retorna `false`.

3. Você pode usar esse resultado para tomar decisões na lógica do seu controlador. Por exemplo, se `hasErrors()` retornar `true`, você pode redirecionar o usuário de volta ao formulário com mensagens de erro. Se retornar `false`, você pode prosseguir com o processamento do formulário.

No Thymeleaf, você também pode usar `${#fields.hasErrors('campo')}` para verificar erros de campo específicos relacionados à validação e exibir mensagens de erro correspondentes na interface do usuário.


# Passo a Passo do método de Controle gravarEstudante()

```java
@PostMapping("/gravarEstudante")
public String gravarEstudante(@ModelAttribute("novoEstudante") @Valid Estudante estudante,
   BindingResult erros, RedirectAttributes redirectAttributes) {
        
   if(erros.hasErrors()){
       return "/novo-estudante";
   }

   estudanteService.criarEstudante(estudante);

   redirectAttributes.addFlashAttribute("mensagem", "Estudante salvo com sucesso!");

   return "redirect:/novo";
}
```

1. `@PostMapping("/gravarEstudante")`: Esta anotação mapeia a solicitação HTTP POST para a URL `/gravarEstudante` a este método do controlador. Isso significa que quando alguém envia um formulário ou faz uma solicitação POST para essa URL, este método será chamado para processar a solicitação.

2. `public String gravarEstudante(@ModelAttribute("novoEstudante") Estudante estudante, RedirectAttributes redirectAttributes)`: Este é o método que lida com a solicitação POST. Aqui estão os parâmetros e o que eles fazem:
   - `@ModelAttribute("novoEstudante") Estudante estudante`: Este parâmetro indica que está esperando que os dados do formulário sejam vinculados a um objeto `Estudante`. O `@ModelAttribute` é usado para vincular os campos do formulário com os campos do objeto `Estudante`. O valor `"novoEstudante"` especifica o nome do modelo usado no formulário para referenciar este objeto.
   - O `@Valid` indica que a validação do objeto deve ser aplicada.
   - `RedirectAttributes redirectAttributes`: Isso é usado para passar atributos entre solicitações ao redirecionar o usuário para uma nova URL. Ele permite que você adicione atributos para transmiti-los para a próxima solicitação após o redirecionamento.
   - O `BindingResult` é usado para capturar erros de validação. Se ocorrerem erros de validação no objeto Estudante, eles serão capturados neste objeto. Se houver erros de validação, o método pode decidir como lidar com eles.

3. `if(erros.hasErrors())`: Esta linha verifica se o objeto erros contém erros de validação. Se houver erros, o método retorna "/novo-estudante", o que provavelmente redireciona o usuário de volta para a página de criação de estudantes com mensagens de erro.

4. `estudanteService.criarEstudante(estudante)`: Esta linha chama um serviço (presumivelmente `estudanteService`) para criar um novo estudante. Os dados do estudante são extraídos do objeto `estudante` que foi vinculado ao formulário.

5. `redirectAttributes.addFlashAttribute("mensagem", "Estudante salvo com sucesso!")`: Aqui, está usando o `RedirectAttributes` para adicionar um atributo "flash" chamado "mensagem". Esse atributo contém uma mensagem que será exibida na próxima solicitação, em uma página que o usuário será redirecionado após a criação bem-sucedida do estudante. A principal diferença entre um atributo flash e um atributo normal é que os atributos flash são automaticamente removidos após a próxima solicitação. Portanto, a mensagem só será exibida uma vez após o redirecionamento.

6. `return "redirect:/novo"`: Finalmente, esta linha redireciona o usuário para a URL `/novo` após a conclusão bem-sucedida da criação do estudante. Isso é feito usando o `"redirect:"` antes da URL, o que instrui o Spring MVC a redirecionar o usuário para a página correspondente.

No geral, esse método é usado para processar a criação de um novo estudante, exibe uma mensagem de sucesso após o redirecionamento para a próxima página e usa o atributo flash para transmitir a mensagem entre as solicitações.

## Bom Saber - validando dados de uma entidade usando Java Bean Validation

### 1. **Anotações de Validação na Classe Estudante:**

```java
public class Estudante {

   ...

   @NotBlank(message = "O nome deve ser informado")
   @Size(min = 2, message = "O nome deve ter no mínimo dois caracteres")
   private String nome;

   @Min(value = 18, message = "O estudante deve ter no mínimo 18 anos de idade")
   private int idade;
}
```

Neste trecho, a classe `Estudante` contém campos `nome` e `idade`, e essas anotações são usadas para definir regras de validação:

- `@NotBlank` garante que o campo `nome` não deve estar em branco (nulo ou vazio). Se estiver em branco, a mensagem de erro "O nome deve ser informado" será exibida.

- `@Size(min = 2)` estabelece que o campo `nome` deve ter um tamanho mínimo de 2 caracteres. Se o nome tiver menos de 2 caracteres, a mensagem de erro "O nome deve ter no mínimo dois caracteres" será exibida.

- `@Min(value = 18)` valida se o campo `idade` é maior ou igual a 18. Se a idade for menor que 18, a mensagem de erro "O estudante deve ter no mínimo 18 anos de idade" será exibida.

### 2. **Método `gravarEstudante` no Controlador:**

```java
@PostMapping("/gravarEstudante")
public String gravarEstudante(@ModelAttribute("novoEstudante") @Valid Estudante estudante,
        BindingResult erros, RedirectAttributes redirectAttributes) {
    
    if (erros.hasErrors()) {
        return "/novo-estudante";
    }
    
    ...
}
```

- `@Valid` é usado na entrada do método para indicar que o objeto `Estudante` deve ser validado de acordo com as regras de validação definidas nas anotações em sua classe.

- `BindingResult erros` é usado para coletar os erros de validação após a validação ter sido executada. Se houver erros, eles serão registrados em `erros`.

- A condição `if (erros.hasErrors())` verifica se existem erros de validação. Se houver erros, o código retorna `/novo-estudante`, levando o usuário de volta ao formulário para corrigir os erros.

### 3. **Formulário Thymeleaf:**

```html

<form th:object="${novoEstudante}" method="post">
    <!-- Restante do formulário -->

    <div class="mb-3" th:if="${#fields.hasErrors('nome')}">
        <span th:each="error : ${#fields.errors('nome')}" class="alert alert-danger" role="alert" th:text="${error}"></span>
    </div>
    
    <!-- Restante do formulário -->
    
    <div class="mb-3">
         <span th:if="${#fields.hasErrors('idade')}" th:errors="*{idade}" class="alert alert-danger" role="alert"></span>
    </div>

     <!-- Restante do formulário -->
</form>
```

- No formulário Thymeleaf está verificando se há erros no campo nome usando `${#fields.hasErrors('nome')}`. Ou seja, essa parte `th:if="${#fields.hasErrors('nome')}"` é uma expressão Thymeleaf. Ela verifica se existem erros de validação no campo nome. Se houver erros, esta divisão é exibida; caso contrário, ela não é renderizada.

- A tag `<span>` é usada para exibir mensagens de erro.

- Essa parte `th:each="error : ${#fields.errors('nome')}"` é uma expressão Thymeleaf que faz um loop por todas as mensagens de erro associadas ao campo nome. Ou seja, se houver erros no campo nome irá iterar os erros e exibir como mensagens de erro em um elemento HTML com a classe `alert alert-danger.`

- A tag `<span>` é usada para exibir mensagens de erro. `th:if="${#fields.hasErrors('idade')}"` verifica se há erros no campo `idade`. Se houver erros, as mensagens de erro associadas a `idade` serão exibidas com `th:errors="*{idade}"`.

Isso permite que o Thymeleaf exiba mensagens de erro no local apropriado do formulário, dependendo das regras de validação definidas nas anotações da classe `Estudante` e das mensagens de erro personalizadas especificadas nas anotações. O código no controlador usa `BindingResult` para capturar os erros e decidir se deve redirecionar o usuário de volta ao formulário ou prosseguir com o processamento, dependendo da validação.

# Passo a Passo do método de Controle listarEstudantes()

```java
@GetMapping("/")
public String listarEstudantes(Model model) {
    
    List<Estudante> estudantes = estudanteService.listarTodosEstudantes();
    
    model.addAttribute("listarEstudantes", estudantes);
    
    return "/lista-estudantes";
}
```

- `@GetMapping("/")`: Esta anotação mapeia solicitações HTTP GET para a URL raiz ("/"). Quando alguém acessa a raiz do seu aplicativo no navegador, essa função será executada.

- `public String listarEstudantes(Model model)`: Esta é a definição de um método que lida com a solicitação. Ele recebe um objeto `Model` como um parâmetro. O objeto `Model` é usado para adicionar dados que serão usados ao renderizar a página.

- `List<Estudante> estudantes = estudanteService.listarTodosEstudantes()`: Aqui, a função chama o serviço `estudanteService` para obter uma lista de estudantes. O objetivo é buscar todos os estudantes para exibi-los na página.

- `model.addAttribute("listarEstudantes", estudantes)`: O método `addAttribute` do objeto `Model` é usado para adicionar um atributo chamado "listarEstudantes" ao modelo. Esse atributo contém a lista de estudantes que foi obtida do serviço.

- `return "/lista-estudantes"`: Finalmente, o método retorna uma string que é o nome da visualização que deve ser usada para renderizar a página. Neste caso, ele retorna "/lista-estudantes", que provavelmente é um modelo Thymeleaf chamado "lista-estudantes". Isso significa que quando o método for concluído, a página "lista-estudantes" será exibida no navegador, e os dados serão preenchidos com a lista de estudantes.

Portanto, esse método é responsável por listar todos os estudantes e exibi-los na página principal do seu aplicativo quando você acessa a URL raiz. A lista de estudantes é passada para a página por meio do objeto `Model`.

## Bom Saber - listando os dados dos estudantes na tabela HTML

```html
<!-- Restante do formulário -->
<tbody>
   <tr th:if="${listarEstudantes.empty}">
      <td colspan="3">Não existe estudantes</td>
   </tr>

   <tr th:each="estudante : ${listarEstudantes}">
      <td><span th:text="${estudante.id}"></span></td>
      <td><span th:text="${estudante.nome}"></span></td>
      <td><span th:text="${estudante.idade}"></span></td>
   </tr>
</tbody>
<!-- Restante do formulário -->
```

O trecho de código HTML acima está associado ao método `listarEstudantes`.

1. No método `listarEstudantes`:

   - Aqui, está recuperando uma lista de estudantes do serviço e a adicionando ao modelo com o nome "listarEstudantes".

2. No trecho de código HTML:

   - `<tr th:if="${listarEstudantes.empty}">`: Esta linha verifica se a lista "listarEstudantes" está vazia. Se a lista estiver vazia, ou seja, não há estudantes para listar, ela exibirá a mensagem "Não existe estudantes" em uma única célula da tabela.

   - `<tr th:each="estudante : ${listarEstudantes}">`: Esta linha é usada em conjunto com a diretiva `th:each` para iterar sobre a lista "listarEstudantes" e exibir informações de cada estudante em uma linha da tabela.

   - `<td><span th:text="${estudante.id}"></span></td>`: Aqui, está extraindo a propriedade "id" de cada estudante na lista e exibindo-a na primeira coluna da tabela.

   - `<td><span th:text="${estudante.nome}"></span></td>`: Da mesma forma, está extraindo a propriedade "nome" de cada estudante e exibindo-a na segunda coluna da tabela.

   - `<td><span th:text="${estudante.idade}"></span></td>`: Novamente, está extraindo a propriedade "idade" de cada estudante e exibindo-a na terceira coluna da tabela.

Em resumo, o trecho de código HTML fornecido percorre a lista de estudantes obtida no método `listarEstudantes` e exibe as informações dos estudantes em uma tabela na página. Se a lista estiver vazia, ele exibirá uma mensagem indicando que não há estudantes. Caso contrário, ele preencherá a tabela com os detalhes de cada estudante na lista.

Classe `Optional`

A classe `Optional` faz parte do Java e foi introduzida nas versões mais recentes (Java 8) para ajudar a lidar com valores opcionais ou nulos de maneira mais segura e funcional. Ela é uma parte importante das bibliotecas de programação funcional introduzidas no Java. 

Principais pontos sobre a classe `Optional`:

1. **Lida com valores possivelmente nulos:** O objetivo principal do `Optional` é fornecer uma maneira de trabalhar com valores que podem ser nulos sem expor o código a possíveis `NullPointerException`. Isso torna o código mais seguro.

2. **API funcional:** O `Optional` fornece uma série de métodos funcionais que permitem realizar operações em valores opcionais, como mapeamento, filtragem, ações condicionais, entre outros.

3. **Criação de Optionals:** Você pode criar um `Optional` a partir de um valor não nulo usando o método `of`, ou a partir de um valor que pode ser nulo usando o método `ofNullable`. Além disso, existem outros métodos para criar Optionals vazios.

   Exemplo:
   ```java
   Optional<String> optionalWithValue = Optional.of("valor não nulo");
   Optional<String> optionalWithNullableValue = Optional.ofNullable(null); // Cria um Optional vazio
   ```

4. **Métodos de consulta:** Você pode verificar a presença de um valor dentro do `Optional` usando o método `isPresent`. Para obter o valor contido, você pode usar `get`. No entanto, é mais seguro usar métodos como `ifPresent` ou `orElse` para evitar `NullPointerException`.

   Exemplo:
   ```java
   if (optional.isPresent()) {
       String valor = optional.get();
   }
   ```

5. **Métodos de ação condicional:** Os métodos como `ifPresent` permitem executar ações quando o valor está presente. Isso é útil para realizar ações somente se o valor existir.

   Exemplo:
   ```java
   optional.ifPresent(valor -> System.out.println("Valor presente: " + valor));
   ```

6. **Mapeamento e filtragem:** Você pode usar métodos como `map` e `filter` para transformar o valor ou filtrá-lo com base em alguma condição.

   Exemplo:
   ```java
   Optional<Integer> resultado = optional.map(valor -> valor.length()); // Mapeia o valor para o comprimento da string
   ```

7. **Recuperação segura de valores padrão:** O método `orElse` permite recuperar um valor padrão caso o `Optional` seja vazio.

   Exemplo:
   ```java
   String valor = optional.orElse("Valor padrão");
   ```

8. **Evitar exceções:** O uso de `Optional` pode ajudar a evitar exceções `NullPointerException`, uma vez que você opera de maneira segura com valores nulos.

Em resumo, a classe `Optional` é uma ferramenta valiosa para lidar com valores possivelmente nulos de maneira segura e funcional no Java. Ela é amplamente usada em programação moderna e é especialmente útil em operações de stream e em situações em que valores nulos podem ser problemáticos.

# Implementando o Delete Estudante

### Passo 1 - Criado o método buscarEstudantePorId() na Classe EstudanteService

Primeiro tem que criar um método que busque o estudante por id em um repositório (`findById`).

```java
public Estudante buscarEstudantePorId(Long id) throws EstudanteNotFoundException{
   Optional<Estudante> optional = estudanteRepository.findById(id);

   if(optional.isPresent()){
       return optional.get();
   }else{
       throw new EstudanteNotFoundException("Estudante com id " + id + " não encontrado!");
   }
}
```

1. `public Estudante buscarEstudantePorId(Long id) throws EstudanteNotFoundException {`
   - O método `buscarEstudantePorId` recebe um parâmetro `id` do tipo `Long` que representa o identificador do estudante que se deseja encontrar. Ele também declara que pode lançar uma exceção `EstudanteNotFoundException`.

2. `Optional<Estudante> optional = estudanteRepository.findById(id);`
   - Um objeto `Optional` é criado. `Optional` é usado aqui porque o resultado da operação de busca pode ou não encontrar um estudante com o ID fornecido. O método `findById` que é fornecido por um repositório JPA, e ele retorna um `Optional` contendo o estudante se encontrado ou vazio se não encontrado.

3. `if (optional.isPresent()) {`
   - Verifica se o `Optional` contém um valor, ou seja, se um estudante com o ID fornecido foi encontrado.

4. `return optional.get();`
   - Se o estudante for encontrado (ou seja, o `Optional` contiver um valor), o método `get()` é chamado no `Optional` para obter o objeto `Estudante` encontrado, que é então retornado pelo método.

5. `} else {`
   - Se o `Optional` estiver vazio, isso significa que o estudante não foi encontrado. Nesse caso, o código dentro do bloco `else` é executado.

6. `throw new EstudanteNotFoundException("Estudante com id " + id + " não encontrado!");`
   - Aqui, uma exceção `EstudanteNotFoundException` é lançada. O `EstudanteNotFoundException` é uma exceção personalizada que pode ser usada para indicar que um estudante com o ID fornecido não foi encontrado. A mensagem da exceção incluirá o ID não encontrado.

O uso de `Optional` nesse método é uma prática recomendada para evitar exceções `NullPointerException` ao buscar objetos que podem não existir no repositório. Quando o estudante não é encontrado, em vez de retornar `null`, ele lança uma exceção personalizada para indicar claramente o motivo da falha na busca. Isso ajuda a tornar o código mais robusto e seguro.

### Passo 2 - Criado o método deletarEstudante() na Classe EstudanteService

Agora com base no id do estudante para identificá-lo é possível executar o delete do estudante.

```java
public void deletarEstudante(Long id) throws EstudanteNotFoundException{

   Estudante estudante = buscarEstudantePorId(id);
   estudanteRepository.delete(estudante);
}
```

1. `public void deletarEstudante(Long id) throws EstudanteNotFoundException {`
   - O método `deletarEstudante` recebe um parâmetro `id` do tipo `Long`, que representa o identificador do estudante a ser excluído. O método também declara que pode lançar uma exceção `EstudanteNotFoundException`.

2. `Estudante estudante = buscarEstudantePorId(id);`
   - Ele chama o método `buscarEstudantePorId(id)` para obter o estudante com o ID fornecido. Isso é feito para garantir que o estudante com o ID exista antes de tentar excluí-lo. Se o estudante não for encontrado, o método `buscarEstudantePorId` lançará uma exceção `EstudanteNotFoundException`.

3. `estudanteRepository.delete(estudante);`
   - Após obter o estudante, ele utiliza um repositório chamado `estudanteRepository` para excluir o estudante. O repositório possui um método `delete` que permite excluir uma entidade (neste caso, um estudante) do banco de dados com base no objeto fornecido. Portanto, o estudante é removido do banco de dados.
4. Observe que o método não precisa retornar o estudante excluído porque ele não é mais necessário após a exclusão. Em vez disso, o método lança uma exceção `EstudanteNotFoundException` se o estudante não for encontrado, o que é uma boa prática para indicar que a exclusão não foi bem-sucedida devido à ausência do estudante.

Em resumo, esse método primeiro verifica se o estudante com o ID fornecido existe usando o método `buscarEstudantePorId`. Se o estudante existir, ele é excluído usando o repositório, caso contrário, é lançada uma exceção para indicar que o estudante não foi encontrado antes da tentativa de exclusão.

### Passo 3 - Criado o método apagarEstudante() na Classe EstudanteController

Agora vamos criar controlador que vai lidar com a exclusão do estudante com base no seu id fornecido.

```java
@GetMapping("/apagar/{id}")
    public String apagarEstudante(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            estudanteService.deletarEstudante(id);
        } catch (EstudanteNotFoundException e) {
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
      return "redirect:/";
}
```

1. `@GetMapping("/apagar/{id}")`
   - Esta é uma anotação `@GetMapping` que mapeia a URL "/apagar/{id}". O `{id}` é uma variável de caminho que pode receber um valor no URL. Isso significa que a URL "/apagar/algum_id" corresponderá a este método.

2. `public String apagarEstudante(@PathVariable("id") Long id, RedirectAttributes redirectAttributes)`
   - Este é o método controlador que lida com a solicitação GET para excluir um estudante. Ele recebe o valor do ID do estudante do URL como um parâmetro usando a anotação `@PathVariable`. Além disso, ele recebe um objeto `RedirectAttributes` que permite adicionar atributos para serem usados na página de redirecionamento.

3. `try { ... } catch (EstudanteNotFoundException e) { ... }`
   - O código dentro do bloco `try` tenta chamar o método `deletarEstudante(id)` do serviço `estudanteService` para excluir o estudante com o ID fornecido. Se uma exceção `EstudanteNotFoundException` for lançada durante a execução do método `deletarEstudante`, isso significa que o estudante não foi encontrado no banco de dados, e a exceção é capturada no bloco `catch`.

4. `redirectAttributes.addFlashAttribute("mensagem", e.getMessage());`
   - Dentro do bloco `catch`, é adicionado um atributo de flash chamado "mensagem" com a mensagem de exceção `e.getMessage()`. Os atributos de flash são usados para passar informações entre solicitações e são especialmente úteis quando você deseja mostrar uma mensagem de erro após um redirecionamento.

5. `return "redirect:/";`
   - Após a tentativa de exclusão, independentemente de ela ter sido bem-sucedida ou não, o método redireciona o usuário de volta para a página inicial ("/"). Qualquer mensagem de erro gerada é exibida na página inicial, graças ao uso de atributos de flash.

Portanto, este script lida com a exclusão de estudantes com base no ID fornecido e redireciona o usuário de volta à página inicial, exibindo uma mensagem de erro se a exclusão não for bem-sucedida devido à não localização do estudante.

# Implementando o Alterar Estudante

### Passo 1 - Criado o método alterarEstudante() na Classe EstudanteService

Primeiro vai ser criado um método para salvar os dados do estudante alterado no banco de dados.


```java
public Estudante alterarEstudante(Estudante estudante){
    return estudanteRepository.save(estudante);
}
```

- `public Estudante alterarEstudante(Estudante estudante)`: Este é um método é projetado para receber um objeto `Estudante` como argumento, que representa os novos dados do estudante que deseja atualizar. O objetivo deste método é atualizar as informações do estudante no banco de dados.

- `estudanteRepository.save(estudante)`: Nesse trecho de código, o método `save` é chamado no `estudanteRepository`. O método `save` é usado para salvar ou atualizar um objeto no banco de dados. Se o objeto `estudante` já existe no banco de dados (com base em sua chave primária, no caso o ID), ou seja, a alteração é realizada no banco de dados, e o mesmo objeto `estudante` (agora atualizado) é retornado como resultado da operação e ele será atualizado com as informações fornecidas. Se o objeto `estudante` ainda não existe no banco de dados, ele será inserido como um novo registro.

Em resumo, esse método `alterarEstudante` aceita um objeto `Estudante` com informações atualizadas, salva essas informações no banco de dados usando o repositório de estudante (`estudanteRepository`) e retorna o objeto `Estudante` atualizado. Isso é útil para realizar operações de atualização de registros no banco de dados, como alterar informações de um estudante existente.

### Passo 2 - Criado o método carregarEstudanteFormParaAlterar() na Classe EstudanteController

Próxima etapa está relacionado à funcionalidade de carregar um formulário para a edição de informações de um estudante. 

```java
@GetMapping("/editar/{id}")
public String carregarEstudanteFormParaAlterar(@PathVariable("id") Long id, RedirectAttributes redirectAttributes, Model model) {
    try {
        Estudante estudante = estudanteService.buscarEstudantePorId(id);

        model.addAttribute("editarEstudante", estudante);
        return "/alterar-estudante";
    } catch (EstudanteNotFoundException e) {
        redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
    }
    return "redirect:/";
}
```

- `@GetMapping("/editar/{id")`: Essa anotação mapeia a URL `/editar/{id}`, onde `{id}` é uma variável de caminho (path variable) que será usada para identificar o ID do estudante que você deseja editar. Isso significa que quando você acessa essa URL, o método será executado.

- `public String carregarEstudanteFormParaAlterar(@PathVariable("id") Long id, RedirectAttributes redirectAttributes, Model model)`: Este é um método que lida com a solicitação GET para editar um estudante. Ele espera receber três parâmetros:
   1. `@PathVariable("id") Long id`: Este é um parâmetro de caminho que extrai o valor do `id` da URL. Ele será usado para identificar o estudante que você deseja editar.
   2. `RedirectAttributes redirectAttributes`: Isso é usado para redirecionar mensagens ou atributos após a conclusão da operação.
   3. `Model model`: Isso é usado para adicionar atributos ao modelo, que podem ser usados na página da web, no caso, no formulário de edição.

- `Estudante estudante = estudanteService.buscarEstudantePorId(id)`: Aqui, o método `buscarEstudantePorId` do serviço é chamado para recuperar o estudante com o ID especificado. Se o estudante com esse ID for encontrado, ele é armazenado na variável `estudante`.

- `model.addAttribute("editarEstudante", estudante)`: O objeto `estudante` é adicionado ao modelo com o nome "editarEstudante". Isso permite que as informações do estudante sejam acessadas na página do formulário de edição.

- `return "/alterar-estudante"`: Após configurar o modelo com os dados do estudante, o método retorna uma string que corresponde ao nome da página ou do modelo Thymeleaf que deve ser renderizado. Neste caso, a página `alterar-estudante` será renderizada para permitir a edição do estudante.

- No caso de ocorrer uma exceção `EstudanteNotFoundException`, o código no bloco `catch` será executado. Isso pode acontecer se o estudante com o ID especificado não for encontrado. Nesse caso, uma mensagem de erro é adicionada aos atributos de redirecionamento (`redirectAttributes`), e o usuário é redirecionado de volta para a página principal ("redirect:/").

Em resumo, este script permite que os usuários acessem um formulário de edição para um estudante específico, identificado pelo seu ID. Se o estudante for encontrado, suas informações serão carregadas no formulário de edição. Se o estudante não for encontrado, o usuário receberá uma mensagem de erro.

### Passo 3 - Criado o método carregarEstudanteFormParaAlterar() na Classe EstudanteController

Essa etapa está relacionado com o processo de edição de um estudante.

```java
@PostMapping("/editar/{id}")
public String editarEstudante(@PathVariable("id") Long id, @ModelAttribute("editarEstudante")
 @Valid Estudante estudante, BindingResult erros) {
    
    if (erros.hasErrors()) {
        estudante.setId(id);
        return "/alterar-estudante";
    }

    estudanteService.alterarEstudante(estudante);

    return "redirect:/";
}
```

- `@PostMapping("/editar/{id}")`: Esta anotação mapeia uma solicitação POST para a URL `/editar/{id}`, onde `{id}` é um parâmetro de caminho que identifica o ID do estudante que está sendo editado.

- `public String editarEstudante(@PathVariable("id") Long id, @ModelAttribute("editarEstudante") @Valid Estudante estudante, BindingResult erros)`: Este é o método responsável por processar a solicitação POST de edição de estudante. Ele recebe os seguintes parâmetros:

   1. `@PathVariable("id") Long id`: Isso extrai o valor de `{id}` da URL, que é usado para identificar o estudante que está sendo editado.

   2. `@ModelAttribute("editarEstudante") @Valid Estudante estudante`: Aqui, o objeto `estudante` é vinculado ao modelo pelo nome "editarEstudante". Essa anotação permite que você recupere os dados do formulário preenchido pelo usuário. O `@Valid` indica que a validação do modelo deve ser aplicada aos dados do estudante. Se ocorrerem erros de validação, eles serão armazenados no objeto `BindingResult`.

   3. `BindingResult erros`: Isso é usado para coletar erros de validação, caso existam.

- `if (erros.hasErrors())`: Aqui, o código verifica se há erros de validação nos dados do estudante. Se houver erros, o código dentro deste bloco será executado.

- `estudante.setId(id)`: Se ocorrerem erros de validação, o ID do estudante é definido com o valor de `id`. Isso é feito para garantir que o ID do estudante não seja perdido durante o processo de edição.

- `return "/alterar-estudante"`: Se ocorrerem erros de validação, o método retorna a página "alterar-estudante" para que o usuário possa corrigir os erros.

- `estudanteService.alterarEstudante(estudante)`: Se não houver erros de validação, o serviço é chamado para alterar os dados do estudante com base nas informações fornecidas no objeto `estudante`. Isso é o que efetivamente realiza a edição do estudante.

- `return "redirect:/"`: Após a edição bem-sucedida, o método redireciona o usuário de volta à página principal do aplicativo.

Em resumo, esse script trata da edição de um estudante. Se houver erros de validação, o usuário será redirecionado de volta ao formulário de edição para corrigi-los. Caso contrário, as alterações serão salvas e o usuário será redirecionado para a página principal.
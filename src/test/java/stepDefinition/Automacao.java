/*
Autor: Leandro Brum
 */

package stepDefinition;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automacao {

    private WebDriver navegador;

    @Dado("^que acessei o site para o teste$")
    public void acessoSite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
    }
    @Quando("^Escolha um produto qualquer na loja$")
    public void escolheProduto() throws InterruptedException {
        navegador.get("http://www.automationpractice.com");
        navegador.manage().window().maximize();

        Thread.sleep(1000);

        navegador.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[7]/div/div[1]/div/a[1]/img")).click();
    }
    @Quando ("^Adicione o produto escolhido ao carrinho$")
    public void adicionaCarrinhos() throws InterruptedException {

        System.out.println(" Estou aqui ");
        Thread.sleep(3000);
        // cria uma variavel int para receber a quantidade de frames
        int size = navegador.findElements(By.tagName("iframe")).size();
        // printa a quantidade de frames
        System.out.println("Total de frames " + size);
            // cria um for para passar pelos frames
        for (int i = 0; i < size; i++) {
            navegador.switchTo().frame(i);
            //entra dentro dos frames encontrados
            if (navegador.findElements(By.id("buy_block")).size() != 0)
                navegador.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
            navegador.switchTo().defaultContent();
       }
    }
    @Quando ("^Prossiga para o checkout$")
    public void abreCheckou() throws InterruptedException {
        navegador.get("http://www.automationpractice.com");
        navegador.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
    }
    @Quando ("^Valide se o produto foi corretamente adicionado ao carrinho e prossiga caso esteja tudo certo (.*)$")
    public void validaMercadoria(String var) throws InterruptedException {
        String var2 = navegador.findElement(By.xpath("//*[@id=\"product_7_34_0_0\"]/td[2]/p/a")).getText();
        Assert.assertTrue(var2.contains("Printed Chiffon Dress"));
        navegador.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
        navegador.findElement(By.id("email_create")).sendKeys(var);
        navegador.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(3000);
        navegador.findElement(By.id("id_gender1")).click();
    }

    @Entao("^Realize o cadastro do cliente preenchendo todos os campos obrigatórios dos formulários$")
    public void macarGenero() throws InterruptedException {
        Thread.sleep(1000);
        navegador.findElement(By.id("id_gender1")).click();
    }
    @Entao("^preencher campo nome (.*)$")
    public void peencheNome(String var1)   {
        navegador.findElement(By.id("customer_firstname")).sendKeys(var1);
    }
    @Entao("^preencher campo sobrenome (.*)$")
    public void preencheSobrenome(String var1)   {
        navegador.findElement(By.id("customer_lastname")).sendKeys(var1);
        navegador.findElement(By.id("email")).click();
    }
    @Entao("^preencher campo senha (.*)$")
    public void preencheSenha(String var1)   {
        navegador.findElement(By.id("passwd")).sendKeys(var1);
    }
    @Entao("^clicar em dia/mes/ano e selecionar opções$")
    public void preencheData()   {
        navegador.findElement(By.id("days")).click();
        navegador.findElement(By.xpath("//*[@id=\"days\"]/option[4]")).click();
        navegador.findElement(By.id("months")).click();
        navegador.findElement(By.xpath("//*[@id=\"months\"]/option[5]")).click();
        navegador.findElement(By.id("years")).click();
        navegador.findElement(By.xpath("//*[@id=\"years\"]/option[5]")).click();
        navegador.findElement(By.id("newsletter")).click();
        navegador.findElement(By.id("optin")).click();
    }
    @Entao("^preencher campo company (.*)$")
    public void campoCompany(String var1)   {
        navegador.findElement(By.id("company")).sendKeys(var1);
    }
    @Entao("^preencher campo addreess (.*)$")
    public void campoAddress(String var1)   {
        navegador.findElement(By.id("address1")).sendKeys(var1);
    }
    @Entao("^preencher campo adrress2 (.*)$")
    public void campoAddress2(String var1)   {
        navegador.findElement(By.id("address2")).sendKeys(var1);
    }
    @Entao("^preencher campo city (.*)$")
    public void campoCity(String var1)   {
        navegador.findElement(By.id("city")).sendKeys(var1);
    }
    @Entao("^clicar no estado$")
    public void campoEstado()   {
        navegador.findElement(By.id("id_state")).click();
        navegador.findElement(By.xpath("//*[@id=\"id_state\"]/option[4]")).click();
    }
    @Entao("^preencher campo cep (.*)$")
    public void campoCep(String var1)   {
        navegador.findElement(By.id("postcode")).sendKeys(var1);
    }

    @Entao("^clicar no pais$")
    public void campoPais()   {
        navegador.findElement(By.id("id_country")).click();
        navegador.findElement(By.xpath("//*[@id=\"id_state\"]/option[4]")).click();
    }
    @Entao("^preencher anotações$")
    public void campoAnotacao()   {
        navegador.findElement(By.id("other")).sendKeys("Teste Automatizado");
    }
    @Entao("^preencher campo phone (.*)$")
    public void campoPhone(String var1)   {
        navegador.findElement(By.id("phone")).sendKeys(var1);
    }
    @Entao("^preencher o celular (.*)$")
    public void phone_mobile(String var1)   {
        navegador.findElement(By.id("phone_mobile")).sendKeys(var1);
    }
    @Entao("^preencher referência$")
    public void alias()   {
        navegador.findElement(By.id("alias")).sendKeys("Mercado 1");
    }
    @Entao("^clicar em registrar$")
    public void aliasss()   {
        navegador.findElement(By.id("submitAccount")).click();
    }
    @Entao("^Valide se o endereço está correto e prossiga.$")
    public void validarRegistro()   {
        String var2 = navegador.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]")).getText();
        Assert.assertTrue(var2.contains("Porto Alegre, Arizona 00000"));
        navegador.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
    }
    @Entao("^Aceite os termos de serviço e prossiga.$")
    public void aceitePr()   {
        navegador.findElement(By.id("cgv")).click();
        navegador.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
    }
    @Entao("Valide o valor total da compra$")
    public void validaValor()   {
        String var2 = navegador.findElement(By.id("total_price")).getText();
        Assert.assertTrue(var2.contains("$18.40"));
    }
    @Entao("Selecione um método de pagamento e prossiga$")
    public void selecionaPagamento()   {
        navegador.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
    }
    @Entao("Confirme a compra e valide se foi finalizada com sucesso$")
    public void confirmaCompra()   {
        navegador.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
        String var2 = navegador.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
        Assert.assertTrue(var2.contains("Your order on My Store is complete."));
        navegador.close();
    }


}

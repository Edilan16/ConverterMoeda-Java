import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Escolha a moeda: ");
		System.out.println(" [1] -USD (DOLAR) ");
		System.out.println(" [2] -EUR (EURO) ");
		System.out.println(" [3] -GBP (LIBRA) ");

		int opcao = entrada.nextInt();
		String moeda = "";

		if (opcao == 1)
			moeda = "USD";
		else if (opcao == 2)
			moeda = "EUR";
		else if (opcao == 3)
			moeda = "GBP";
		else {
			System.out.println("Opção Invalida! ");
			entrada.close();
			return;
		}

		System.out.println("Digite o valor : ");
		double valor = entrada.nextDouble();

		try {
			String apikey = System.getenv("FASTFOREX_API_KEY");
			if (apikey == null || apikey.isBlank()) {
				System.out.println(
					"API key não encontrada. Defina a variável de ambiente FASTFOREX_API_KEY e tente novamente.");
				entrada.close();
				return;
			}

			// TODO: Ajuste este endpoint/parametros conforme a documentação da API.
			String url = "https://api.fastforex.io/fetch-all" + apikey + "/latest" + moeda;

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			String json = response.body();
			// pega o valor do BRL dentro do JSON
			int index = json.indexOf("\"BRL\":");
			int inicio = index + 6;
			int fim = json.indexOf(",", inicio);

			double cotacao = Double.parseDouble(json.substring(inicio, fim));
			double convertido = valor * cotacao;
			System.out.printf("Valor em reais : %.2f\n ", convertido);

		} catch (Exception e) {
			System.out.println("Erro ao buscar cotação: " + e.getMessage());
		}

		entrada.close();
	}
}
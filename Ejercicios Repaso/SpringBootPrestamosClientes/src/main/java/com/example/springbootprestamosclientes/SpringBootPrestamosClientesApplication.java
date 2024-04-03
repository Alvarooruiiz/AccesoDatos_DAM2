package com.example.springbootprestamosclientes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@SpringBootApplication
public class SpringBootPrestamosClientesApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("""
				Elija una:
				1. GET
				2. POST
				3. DELETE
				4. UPDATE
				""");
		int opcion = sc.nextInt();

		switch (opcion){
			case 1 -> {
				GetRequest();
			}
			case 2 -> {
				PostRequest();
			}
			case 3 -> {
				System.out.println("Código del Autor a borrar: ");
				int codigoBorrar = sc.nextInt();
				DeleteRequest(codigoBorrar);
			}
			case 4 -> {
				System.out.println("Código del Autor a Actualizar");
				int codigoActualizar = sc.nextInt();
				PutRequest(codigoActualizar);
			}
		}
	}

	public static void GetRequest() {
		HttpURLConnection conn = null;
		try {
			URL url = new URL("http://localhost:8080/" + "api-rest/autores");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Accepts", "application/json");

			if (conn.getResponseCode() == 200) {
				Scanner scanner = new Scanner(conn.getInputStream());
				String response = scanner.useDelimiter("\\z").next();
				scanner.close();

				JSONArray jsonArray = new JSONArray(response);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = (JSONObject) jsonArray.get(i);
					System.out.println(jsonObject.get("idAutor") + " " + jsonObject.get("nombreAutor") + " " + jsonObject.get("pais"));
				}
			} else {
				System.out.println("Fallo en la conexion");
			}
		} catch (IOException | JSONException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static void PostRequest(){
		HttpURLConnection conn = null;
		String jsonInputString = null;
		try {
			jsonInputString = new JSONObject().put("idAutor", 1234)
					.put("nombreAutor", "Autor Jorge")
					.put("pais", "Nueva Guinea Ecuatorial")
							.toString();
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
		try {
			URL url = new URL("http://localhost:8080/api-rest/autores");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			try (OutputStream os = conn.getOutputStream()) {
				byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
				os.write(input, 0, input.length);
			}

			if (conn.getResponseCode() == 200) {
				System.out.println("Autor insertado");
			} else {
				System.out.println("Fallo en la conexion");

				Scanner scanner = new Scanner(conn.getErrorStream());
				String response = scanner.useDelimiter("\\z").next();
				scanner.close();

				JSONObject jsonObject = new JSONObject(response).getJSONArray("errors").getJSONObject(0);
				System.out.println(jsonObject.get("defaultMessage"));
			}
		} catch (IOException | JSONException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static void DeleteRequest (int codeToDelete) {
		HttpURLConnection conn = null;
		try {
			URL url = new URL("http://localhost:8080/" + "api-rest/autores/" + codeToDelete);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");

			if (conn.getResponseCode() == 200) {
				System.out.println("Autor borrado");
			} else {
				System.out.println("Fallo en la conexion");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static void PutRequest(int idActualizar){
		HttpURLConnection conn = null;
		String jsonInputString = null;

		try {
			jsonInputString = new JSONObject()
					.put("idAutor", idActualizar)
					.put("nombreAutor", "JorgeSegundo")
					.put("pais", "Eslovaquia")
					.toString();
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}

		try {
			URL url = new URL("http://localhost:8080/api-rest/autores/" + idActualizar);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			try (OutputStream os = conn.getOutputStream()) {
				byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
				os.write(input, 0, input.length);
			}

			if (conn.getResponseCode() == 200) {
				System.out.println("Autor actualizado");
			} else {
				System.out.println("Falló la conexión");

				Scanner scanner = new Scanner(conn.getErrorStream());
				String response = scanner.useDelimiter("\\z").next();
				scanner.close();

				JSONObject jsonObject = new JSONObject(response).getJSONArray("errors").getJSONObject(0);
				System.out.println(jsonObject.get("defaultMessage"));
			}
		} catch (IOException | JSONException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}

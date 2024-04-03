package com.example.examenapirestcliente;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@SpringBootApplication
public class ExamenApiRestClienteApplication {

	public static void buscarUsuarios() {
		HttpURLConnection conn = null;

		try {
			URL url = new URL("http://localhost:8080/api-rest/usuarios");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() == 200) {
				Scanner scanner = new Scanner(conn.getInputStream());
				String response = scanner.useDelimiter("\\Z").next();
				scanner.close();

				JSONArray jsonArray = new JSONArray(response);

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					System.out.println(jsonObject.getInt("idUsuario") + " " + jsonObject.getString("nombreUsuario") + " " + jsonObject.getString("email"));
				}
			} else {
				System.out.println("Fallo en la conexión.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static void guardarUsuario(JSONObject usuarioData) {
		HttpURLConnection conn = null;

		try {
			URL url = new URL("http://localhost:8080/api-rest/usuarios");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(usuarioData.toString().getBytes());
			os.flush();
			os.close();

			if (conn.getResponseCode() == 200) {
				System.out.println("Usuario guardado exitosamente.");
			} else {
				System.out.println("Fallo al guardar el usuario.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static void borrarUsuario(int idUsuario) {
		HttpURLConnection conn = null;

		try {
			URL url = new URL("http://localhost:8080/api-rest/usuarios/" + idUsuario);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");

			if (conn.getResponseCode() == 200) {
				System.out.println("Usuario borrado exitosamente.");
			} else {
				System.out.println("Fallo al borrar el usuario.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static void main(String[] args) throws JSONException {
		buscarUsuarios();

		JSONObject usuarioData = new JSONObject();
		usuarioData.put("nombreUsuario", "Alvaro");
		usuarioData.put("email", "alvaro@gmail.com");
		guardarUsuario(usuarioData);


//		borrarUsuario(6);
	}

}

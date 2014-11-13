package goEuro;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {

	private final static Gson gson = new Gson();

	public static final String FILE_NAME = "result.csv";

	public static void main(String args[]) {

		if (args.length != 1 || args[0].isEmpty()) {
			System.out.println("Proper Usage is: java -jar GoEuro.jar \"STRING\", where STRING is not empty");
			System.exit(0);
		}

		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append("http://api.goeuro.com/api/v2/position/suggest/en/");
		String parameter = args[0];
		urlBuilder.append(parameter);

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(urlBuilder.toString());

		request.addHeader("User-Agent", "GoEuroAgent");
		try {
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			createCSVFile(result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createCSVFile(String json) {
		//Use Google gson to parse the json into a list of LocationElements.
		final Type type = new TypeToken<Collection<LocationElement>>() {
		}.getType();
		GeoPosition geoPosition;
		String elementId;
		String elementName;
		String elementType;
		String elementLatitude;
		String elementLongitude;
		try {
			FileWriter writer = new FileWriter(FILE_NAME);
			CSVWriter csvWriter = new CSVWriter(writer);
			Collection<LocationElement> locationResponse = gson.fromJson(json, type);
			csvWriter.writeRow("_id", "name", "type", "latitude", "longitude");
			for (LocationElement element : locationResponse) {
				geoPosition = element.getGeoPosition();
				elementId = Integer.toString(element.get_id());
				elementName = element.getName();
				elementType = element.getType();
				elementLatitude = Double.toString(geoPosition.getLatitude());
				elementLongitude = Double.toString(geoPosition.getLongitude());
				csvWriter.writeRow(elementId, elementName, elementType, elementLatitude, elementLongitude);
			}
			csvWriter.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


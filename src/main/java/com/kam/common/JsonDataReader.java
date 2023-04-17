package com.kam.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

/**
 * @author kamlesh
 *
 */
@Log4j2
public class JsonDataReader {

	private final String customerFilePath = System.getProperty("user.dir")
			+ "/src/test/resources/data/searchTestData.json";

	private List<Map<String, Object>> getCustomerData() {
		Gson gson = new Gson();
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(customerFilePath));) {
			Map<String, Object>[] customers = gson.fromJson(bufferReader, Map[].class);
			return Arrays.asList(customers);
		} catch (FileNotFoundException e) {
			log.error("Json file not found at path : " + customerFilePath);
			log.error(e);
		} catch (IOException e1) {
			log.error(e1);
		}
		return Collections.emptyList();
	}

	public static void main(final String[] args) {
		System.out.println(new JsonDataReader().getCustomerData());
	}
}

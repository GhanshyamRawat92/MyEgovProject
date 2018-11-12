package org.egov.property.file.reader;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.egov.pt.web.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	PropertyFileReader propertyFileReader;
	
	@GetMapping("/read")
	public ResponseEntity<?> readFile(@RequestParam(name="path") String path)	{
		System.out.println(path);
		Map<String, Property> propertyIdMap = null;
		try {
			propertyIdMap = propertyFileReader.parseExcel(path);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Map>(propertyIdMap, HttpStatus.CREATED);
	}

}

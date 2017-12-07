package com.kossine.ims.utility;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.kossine.ims.utility.exceltodb.format.ExcelSheetFormatLoader;

public class JsonToConsole {

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		File file=new File("/home/jigar/workspace/ims/src/main/java/com/kossine/ims/utility/exceltodb/format.json");
		ExcelSheetFormatLoader esfl=new ExcelSheetFormatLoader(file);
		System.out.println(esfl.loadFromJson());
	}
}

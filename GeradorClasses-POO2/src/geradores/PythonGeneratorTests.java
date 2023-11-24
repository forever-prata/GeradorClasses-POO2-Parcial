package geradores;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import jsonRead.LeitorJson;

class PythonGeneratorTests {

	  @Test
	  void testGerar() throws IOException {
		  LeitorJson leitor = new LeitorJson();
	      String json = leitor.lerArquivo("output/example.json");
	      Generator generator = new PythonGenerator(json);
	      generator.Gerar();
	      String expectedFilePath = "output/Pessoa.py";
	      assertTrue(new File(expectedFilePath).exists());
	  }

	  @Test
	  void testGerarInvalidJsonPath() {
	      String invalidJsonPath = "invalidpath.json";

	      assertThrows(IOException.class, () -> {
	          LeitorJson leitor = new LeitorJson();
	          String json = leitor.lerArquivo(invalidJsonPath);

	          Generator generator = new PhpGenerator(json);
	          generator.Gerar();
	      }, "IOException should be thrown for an invalid JSON file path.");
	  }
}
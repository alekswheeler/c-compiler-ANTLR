
// import ANTLR's runtime libraries
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.NoSuchFileException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import tools.*;

public class Main {
	public static void main(String[] args) throws Exception {

		// Cria um CharStream que lê os caracteres de um arquivo.
		CharStream input = CharStreams.fromFileName(args[0]);

		// create a lexer that feeds off of input CharStream
		CLexer lexer = new CLexer(input);

		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create a parser that feeds off the tokens buffer
		CParser parser = new CParser(tokens);
		parser.setErrorHandler(new NewBailErrorStrategy());
		parser.addErrorListener(new ThrowingErrorListener());

		try {
			System.out.println("Iniciando teste");
			ParseTree tree = parser.compilationUnit(); // begin parsing at init rule
			// System.out.println(tree.toStringTree(parser)); // print LISP-style tree
			System.out.println("Revisão sintática realizada com êxito.");
		} catch (Exception e) {
			System.out.println("Infelizmente um erro ocorreu no analisador sintático.");
		}
	}
}


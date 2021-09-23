package sr.bludots.memory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoadingBar {
		
		public static void main(String[] args) throws InterruptedException {
			int count = 0;

			for (count = 1; count <= 100; ++count) {
				int barSize = count / 10;
				String s = createBar(barSize, 23);
				s += count + "%";
				System.out.print(s);
				if (count >= 0 && count < 90) {
					Thread.sleep(80);
				} else if (count >= 90) {
					Thread.sleep(500);
				}
				for (int i=0; i <s.length(); i++) {
					System.out.print("\b");
				}
			}
		}
	
				
		public static void main1(String[] args) throws InterruptedException {

			int count = 0;

			for (count = 1; count <= 100; ++count) {
				if (count >= 1 && count < 10) {
					System.out.print("[           ]");
				} else if (count >= 10 && count < 20) {
					System.out.print("[■          ]");
				} else if (count >= 20 && count < 30) {
					System.out.print("[■■         ]");
				} else if (count >= 30 && count < 40) {
					System.out.print("[■■■        ]");
				} else if (count >= 40 && count < 50) {
					System.out.print("[■■■■       ]");
				} else if (count >= 50 && count < 60) {
					System.out.print("[■■■■■      ]");
				} else if (count >= 60 && count < 70) {
					System.out.print("[■■■■■■     ]");
				} else if (count >= 70 && count < 80) {
					System.out.print("[■■■■■■■    ]");
				} else if (count >= 80 && count < 90) {
					System.out.print("[■■■■■■■■   ]");
				} else if (count >= 90 && count < 100) {
					System.out.print("[■■■■■■■■■■ ]");
				} else if (count == 100) {
					System.out.print("[■■■■■■■■■■■]");
				}
				System.out.print(count + "%");
				if (count >= 0 && count < 90) {
					Thread.sleep(80);
				} else if (count >= 90) {
					Thread.sleep(500);
				}
				System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");

			}
			System.out.println("[■■■■■■■■■■■]100%");

			System.out.print("Install complete!");
		}

		/* 
		 * Create a bar met de opgegeven lengte;
		 * 
		 */
		public static String createBar(int width, int maxWidth) {
			String bar = "[";
			String blokje = "■";
			for (int i=0; i< width; i++) {
				bar = bar + blokje;
			}
			for (int i = width; i<maxWidth; i++) {
				bar = bar + " ";
			}
			bar += "]";
			return bar;
		}
		
		public static void main2(String[] arg) throws Exception {
			FileWriter writer = new FileWriter(
					"C:\\Tools\\workspace\\File\\src\\com\\bootcamp\\app\\Names.txt");

			String names[] = { "justin", "bryan", "juscelino", "enverny", "kirsten", "jianti" };

			int len = names.length;

			for (int i = 0; i < len; i++) {
				writer.write(names[i] + "\n");
			}
			writer.close();
		}
		
		public static String[] names = { "Freddy Krueger", "Bryan Bijlhout", "Juscelino Kartoebi", "Kirsten Mentopawiro",
		"Bryan Doorson" };

		
		public static void writeNamesInFile() {
			File textFile = new File("names.txt");
			int tries = 0;
			try {
				FileWriter writer = new FileWriter(textFile, true);
			
				while (tries < names.length) {
					writer.write(names[tries++] + "\n");
				}
				
				writer.close();
			} catch (IOException io) {
					System.err.println("Something went wrong:" + io.getMessage());
			}
			System.out.println("TextFile size = "+textFile.length() + "bytes");
			
		}
	}

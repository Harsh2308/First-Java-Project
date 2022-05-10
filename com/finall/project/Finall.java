package com.finall.project;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Finall {
	
	//NEW FILE//
	public static void add()
	{
		try {
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("ENTER FILE NAME WITH LOCATION FOR SAVE FILE (e.g --> path\\FileName.txt):-->");
				String filename = sc.nextLine();

				FileOutputStream fos = new FileOutputStream(filename, true);
				System.out.println("ENTER FILE CONTENT :-->");
				String contain = sc.nextLine();
				byte b[] = contain.getBytes();

				fos.write(b);
				fos.close();
			}
			System.out.println("FILE SUCESSFULLY SAVED :-->");

		} catch (Exception e) {
			System.out.println("EXCEPTION COMING.");
			e.printStackTrace();
		}
	}

	//ASENDING ORDER//
	public static void accendingorder() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("ENTER PATH TO SHOW YOUR FILE IN ASENDING ORDER (e.g --> path\\FileName.txt):-->");

			String filename = sc.nextLine();
			File dir = new File(filename);
			if (dir.isDirectory()) {
				File[] files = dir.listFiles();
				System.out.println("THIS PATH CONTAINS FOLLOWING FILES :--> ");

				extracted(files);

				for (File file : files)
				{
					System.out.println(file.getName());
				}
				System.out.println("AFTER THE SORTING OF YOUR FILE'S WE GOT THIS ASENDING ORDER :-->");

				for (File file : files) {
					System.out.println(file.getName());
				}
				System.out.println("=============================================================");

			}
		}
	}

	private static void extracted(File[] files) {
		Arrays.sort(files, new Comparator<Object>() {
			public int compare(Object f1, Object f2) {
				return ((File) f1).getName().compareTo(((File) f2).getName());
			}
		});
	}

	// DELETE//
	public static void delete() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out
					.println("ENTER THE FILE NAME WITH LOCATION FOR DELETE THE FILE (e.g --> path\\FileName.txt):-->");

			String filename = sc.nextLine();
			File file = new File(filename);
			if (file.delete()) {
				System.out.println("FILE IS DELECTED SUCESSFULLY");
			} else {
				System.out.println("DELECTED PROCESS FAILED");
			}
		}
	}

	//SEARCH//
	public static void search() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("ENTER THE FILE NAME WHICH YOU WANT TO SEARCH (e.g --> path\\FileName.txt):---> ");
			String filename = sc.nextLine();
			File fff = new File(filename);

			if (fff.exists()) {
				System.out.println("FILE FOUND \n");
			} else
				System.out.println("FILE NOT FOUND");
		}
	}

	// MAIN METHOD IS START//
	public static void main(String[] args) {

		System.out.println("************Welcome to Lockedme.com************");
		System.out.println("------------------------------------------");
		System.out.println("************DEVELOPER DETAIL'S");
		
		System.out.println("Developer Name : Harsh Verma." + "\nDesignation : Java Developer.\n" + "Date : 11/05/2022");

		try (Scanner console = new Scanner(System.in)) {
			int ch;
			System.out.print(" \nEnter : 1 for Geting Files Name's In ASENDING ORDER. "
					+ "\nEnter : 2 For BUSSINESS LEVEL OPERATION'S. " + "\nEnter : 3 For CLOSE the Application.\n\n\t");

			ch = console.nextInt();

			switch (ch) {
			case 1:
				accendingorder();
				break;
			case 2:
				int ch2;

				System.out.println("FOLLOWING ARE THE BUSSINESS OPERATION'S --->");
				System.out.print("\nEnter : a For CREATE or ADD NEW FILE.)" + "\nEnter : b For DELETE the File."
						+ "\nEnter : c For SEARCH the File." + "\nEnter : d To GO BACK.\n\n\t");
				ch2 = console.next().charAt(0);

				switch (ch2) {
				case 'a':
					add();
					break;

				case 'b':
					delete();
					break;

				case 'c':
					search();
					break;

				case 'd':
					System.exit(ch2);
					break;
				}
				break;
			case 3:
				System.out.println("SYSTEM GONNA CLOSE\nVISIT AGAIN THANK YOU..");
				System.exit(ch);

			default:
				System.out.println("SOMETHING GOES WRONG(EXCEPTION)....");
				break;
			}
		}
	}
}

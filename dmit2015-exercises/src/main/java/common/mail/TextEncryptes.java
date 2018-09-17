package common.mail;

import org.jasypt.util.text.StrongTextEncryptor;

public class TextEncryptes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
		textEncryptor.setPassword("Password2015");
		String myEncryptedText = textEncryptor.encrypt("myPassword2015");
	    System.out.println("Encrypted Text: " + myEncryptedText);
		String plainText = textEncryptor.decrypt(myEncryptedText);
		System.out.println("Plain Text:"+ plainText);
	}

}

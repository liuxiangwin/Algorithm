package liuxiangwin.JavaObjectTrainningtest.StringToken;

import java.util.StringTokenizer;

public class StringToken {
	public static void main(String args[]) {
		String test = "Alan is very diligence person";

		StringTokenizer tokenizer = new StringTokenizer(test);

		String[] token = new String[tokenizer.countTokens()];

		System.out.println(tokenizer.countTokens());

		System.out.println(token.length);

		// initializtion the new token String array
		// for(int i=0;i<tokenizer.countTokens();i++){
		for (int i = 0; i < token.length; i++) {

			token[i] = tokenizer.nextToken();
		}
		// Push out the new token string array
		for (int i = 0; i < tokenizer.countTokens(); i++) {
			// for (int i = 0; i < token.length; i++) {

			System.out.println(token[i] + "\n");
		}

		String s = new String(
				"The Java platform is the ideal platform for network computing");
		StringTokenizer st = new StringTokenizer(s);
		System.out.println("Token Total: " + st.countTokens());
		while (st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}

		//String s = new String(
		//		"The=Java=platform=is=the=ideal=platform=for=network=computing");

		String dotNet = new String(
				"The .Net platform is also good platform for network computing");
		StringTokenizer dotNetToken = new StringTokenizer(dotNet, ".", false);
		System.out.println("Token Total: " + dotNetToken.countTokens());
		while (dotNetToken.hasMoreElements()) {
			System.out.println(dotNetToken.nextToken());
		}

		

	}
}

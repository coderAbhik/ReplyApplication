package com.beta.replyservice;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.exception.RecordNotFoundException;

/**
 * @author Abhishek_Kumar
 * Class Description: Helper Service for Reply Service Application.
 *  
 * */


@Service
public class ReplyHelperService {

	@Autowired
	ReplyController replyController;

	public String businessLogic(String str) throws RecordNotFoundException {
		if (str == null) {
			throw new RecordNotFoundException("Invalid input");
		}

		String sArray[] = str.split("-");
		if (sArray[0] == null || sArray[1] == null) {
			throw new RecordNotFoundException("Invalid input");
		}
		if (sArray[0].isEmpty() || sArray[1].isEmpty()) {
			throw new RecordNotFoundException("Invalid input");
		}
		String s = sArray[1];
		String reverseNum = reverseString(sArray[0]);

		int num;
		try {
			num = Integer.parseInt(reverseNum);
		} catch (NumberFormatException e) {
			throw new RecordNotFoundException("Invalid input");
		}
		while (num > 0) {
			int i = num % 10;

			if (i == 1) {
				s = reverseString(s);
			} else if (i == 2) {
				s = performMDEncryption(s);
			} else {
				throw new RecordNotFoundException("Invalid input");
			}

			num = num / 10;

		}

		return s;
	}

	public String performMDEncryption(String message) {
		try {

			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(message.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}

	public String reverseString(String message) {
		// reverse string
		StringBuffer sb = new StringBuffer(message);
		return sb.reverse().toString();
	}

}

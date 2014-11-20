package tools.md5;

import java.security.NoSuchAlgorithmException;

public interface MD5Decoder {

	public String md5(String input) throws NoSuchAlgorithmException;
}

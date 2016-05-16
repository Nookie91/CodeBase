import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class ExampleRSA
{
    public static final String ALGORITHM = "RSA";


    public static void main(String[] args)
    {
        KeyPairGenerator keyGen = null;
        try
        {
            keyGen = KeyPairGenerator.getInstance(ALGORITHM);
        }
        catch(Exception e)
        {
            System.out.println("Fucked IT!");
        }

        keyGen.initialize(1024);
        final KeyPair keys = keyGen.generateKeyPair();
        System.out.println("Public Key: " + keys.getPublic());
        System.out.println("Private Key: " + keys.getPrivate());
    }
}

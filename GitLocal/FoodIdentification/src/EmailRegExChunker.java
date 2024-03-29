import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.chunk.RegExChunker;

import java.util.Iterator;
import java.util.Set;

public class EmailRegExChunker extends RegExChunker {
//regex simple
    static final long serialVersionUID = 3470881161284804670L;

    public EmailRegExChunker() {
        super(EMAIL_REGEX,CHUNK_TYPE,CHUNK_SCORE);
    }

    // regex by Bilou McGyver (real name?), taken from:
    // http://regexlib.com/UserPatterns.aspx?authorId=877482cc-dd7d-4797-a824-7fafada2ab62
    private final static String EMAIL_REGEX
        ="[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*) pizza"; //"[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})"

    private final static String CHUNK_TYPE = "email";
    
    private final static double CHUNK_SCORE = 0.0;

    public static void main(String[] args) {
    	//args={"John's email is john@his.company.com and his friend's is foo.bar@123.foo.ca."};
    	String data= "apple juice is tast";
        Chunker chunker = new EmailRegExChunker();
        for (int i = 0; i < 1; ++i) {
            Chunking chunking = chunker.chunk(data);
            System.out.println("input=" + data);
            System.out.println("chunking=" + chunking);
            for (Chunk chunk : chunking.chunkSet()) {
                int start = chunk.start();
                int end = chunk.end();
                String text = data.substring(start,end);
                System.out.println("     chunk=" + chunk + "  text=" + text);
            }
        }
    }

}
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.book.DBops;

public class DBopsTest {
    DBops db=new DBops();
    @Test
    public void testRead(){
        db.getContactList();
        Integer size=db.contactList.size();
        boolean result = (size != null) || (size > 0);
        assertTrue(result);
    }

    @Test
    public void testAddContact(){
         db.getContactList();
        Integer sizeBefore=db.contactList.size();
        db.addContact("Hiya", "Kim", "aaaaa", "gaya", "VR", "123456", "91 3333333333", "hiy@gmail.com");
        Integer sizeAfter=db.contactList.size();
        assertEquals(sizeBefore+1, sizeAfter);
    }

    @Test
    public void testDelete(){
         db.getContactList();
          Integer sizeBefore=db.contactList.size();
        db.deleteEntryFromDb("Hiya", "Kim");
           Integer sizeAfter=db.contactList.size();
        assertEquals(sizeBefore-1, sizeAfter);
    }

  
    
}

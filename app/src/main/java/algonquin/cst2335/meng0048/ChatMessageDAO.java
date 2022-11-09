package algonquin.cst2335.meng0048;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

// class for doing CRUD
@Dao
public interface ChatMessageDAO {

    @Insert
     void insertMessage(ChatMessage m);

    @Query("Select * from ChatMessage")
     List<ChatMessage> getAllMessages();

    @Delete
    void deleteMessage(ChatMessage m);

//    @Query("Delete From ChatMessage Where id = :id")
//    public void deleteChatMessageByID(int id);





}

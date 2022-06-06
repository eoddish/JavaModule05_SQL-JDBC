package edu.school21.chat.repositories;

import edu.school21.chat.models.*;
import java.util.*;

public interface MessagesRepository {
    public Optional<Message> findById(Long id);
    public void save(Message message);
}

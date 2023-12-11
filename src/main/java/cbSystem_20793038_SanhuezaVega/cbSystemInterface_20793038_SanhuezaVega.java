package cbSystem_20793038_SanhuezaVega;

import chatbot_20793038_SanhuezaVega.chatbot_20793038_SanhuezaVega;
import user_20793038_SanhuezaVega.user_20793038_SanhuezaVega;

public interface cbSystemInterface_20793038_SanhuezaVega {
    void systemAddChatbot(chatbot_20793038_SanhuezaVega cb);
    void systemAddUser(user_20793038_SanhuezaVega user);
    void systemLogin(String username);
    void systemLogout();
}

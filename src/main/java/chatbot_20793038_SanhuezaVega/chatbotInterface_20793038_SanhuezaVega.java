package chatbot_20793038_SanhuezaVega;

import flow_20793038_SanhuezaVega.flow_20793038_SanhuezaVega;

import java.util.ArrayList;

public interface chatbotInterface_20793038_SanhuezaVega {
    int getId();
    String getName();
    String getWelcomeMessage();
    int getStartFCodelink();
    ArrayList<flow_20793038_SanhuezaVega> getFlowList();
    void chatbotAddFlow(flow_20793038_SanhuezaVega fl);
}

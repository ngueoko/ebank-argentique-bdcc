package org.ngueoko.ebankaiagent;

import org.ngueoko.ebankaiagent.agents.EbankAiAgent;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EbankAgentRestController {

    private EbankAiAgent ebankAiAgent;

    public EbankAgentRestController(EbankAiAgent ebankAiAgent) {
        this.ebankAiAgent = ebankAiAgent;
    }


    public String chat(String query){
        return ebankAiAgent.chat(query);
    }
}

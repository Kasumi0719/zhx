public class processorFactory {
    public static UndefinedProcessor getQuestionProcessor(String req){
        if(req == "A"){
            return new AgentQuestionProcessor();
        }
        return new textQuestionProcessor();
    }
}

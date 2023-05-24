package utils;


import io.cucumber.java.Scenario;

public class ScenarioCache {
    
    private static Scenario SCENARIO;
    
    public static void cacheScenario(Scenario SCENARIO){
        ScenarioCache.SCENARIO=SCENARIO;
    }
    
    public static Scenario getCacheScenario(){
        return SCENARIO;
    }


}

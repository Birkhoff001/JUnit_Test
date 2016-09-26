package interface_test;

public class FuckTheCode {
	public void main(String[] args) {
		int[] score = {90, 85, 55, 94, 77};
		for(int i = 0; i < score.length; i++)
		    System.out.printf("score[%d] = %d\n", i, score[i]);
		}
}
/*
public void getJSONObject(){
    JSONObject node = JSONObject.fromObject("{'weatherinfo':{'city':'北京','cityid':'101010100','temp1':'-8℃','temp2':'4℃','weather':'晴','img1':'n0'}}");
    List<Object>  nodes = new ArrayList<Object>();

    JSONArray jsons = JSONArray.fromObject(node.get("weatherinfo"));
     
    for (Object o : jsons)
    {
        JSONObject jsonNode = JSONObject.fromObject(o);
        List<Object> treeNodes = new ArrayList<Object>();
        treeNodes.add(jsonNode.getString("city"));
        treeNodes.add(jsonNode.getString("cityid"));
        treeNodes.add(jsonNode.getString("temp1"));
        treeNodes.add(jsonNode.getString("temp2"));
        //...
        nodes.add(treeNodes);
    }
 
System.out.println(nodes);
}


Map<String, Map<String, Object>> maps = objectMapper.readValue(json, Map.class);
        System.out.println(maps.size());
        Set<String> key = maps.keySet();
        Iterator<String> iter = key.iterator();
        while (iter.hasNext()) {
            String field = iter.next();
            System.out.println(field + ":" + maps.get(field));
*/
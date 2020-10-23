package solution;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class Adaptor {
    private static String json="{\n" +
            "\t\"repoId\": \"3ecf804e-0ad6-11eb-bb79-5b7ba969027e\",\n" +
            "\t\"issueCategory\": \"Code smell\",\n" +
            "\t\"endCommit\": \"7697c69d749dad14f37e1a6072b0090cb869caf2\",\n" +
            "\t\"startCommitDate\": \"2020-03-08 17:08:12\",\n" +
            "\t\"adder\": \"linshengwang\",\n" +
            "\t\"type\": \"String literals should not be duplicated\",\n" +
            "\t\"priority\": \"Urgent\",\n" +
            "\t\"uuid\": \"78489df5-5783-4fbd-83e8-824293f08326\",\n" +
            "\t\"tool\": \"sonarqube\",\n" +
            "\t\"lastSolveTime\": null,\n" +
            "\t\"lastSolveCommit\": null,\n" +
            "\t\"startCommit\": \"3750dd1c8abadb521fbe3540c09c9a2f353c4c31\",\n" +
            "\t\"endCommitDate\": \"2020-10-09 07:50:25\",\n" +
            "\t\"detail\": [{\n" +
            "\t\t\t\"uuid\": \"1ea900e3-cd48-4bd5-a493-9f58ae072746\",\n" +
            "\t\t\t\"start_line\": 307,\n" +
            "\t\t\t\"end_line\": 307,\n" +
            "\t\t\t\"bug_lines\": \"\",\n" +
            "\t\t\t\"start_token\": 0,\n" +
            "\t\t\t\"end_token\": 0,\n" +
            "\t\t\t\"file_path\": \"issue-service/src/main/java/cn/edu/fudan/issueservice/service/impl/BaseMappingServiceImpl.java\",\n" +
            "\t\t\t\"class_name\": null,\n" +
            "\t\t\t\"method_name\": \"modifyToOpenTagByRawIssues(List)\",\n" +
            "\t\t\t\"rawIssue_id\": \"ce5503c4-02e5-4cf3-abdf-031e5d3e8839\",\n" +
            "\t\t\t\"code\": \"            tagged.put(\\\"itemId\\\", issue.getUuid());\\n\",\n" +
            "\t\t\t\"locationMatchResultDTOS\": null,\n" +
            "\t\t\t\"matched\": false,\n" +
            "\t\t\t\"matchedIndex\": 0\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"uuid\": \"1ea900e3-cd48-4bd5-a493-9f58ae072746\",\n" +
            "\t\t\t\"start_line\": 307,\n" +
            "\t\t\t\"end_line\": 307,\n" +
            "\t\t\t\"bug_lines\": \"\",\n" +
            "\t\t\t\"start_token\": 0,\n" +
            "\t\t\t\"end_token\": 0,\n" +
            "\t\t\t\"file_path\": \"issue-service/src/main/java/cn/edu/fudan/issueservice/service/impl/BaseMappingServiceImpl.java\",\n" +
            "\t\t\t\"class_name\": null,\n" +
            "\t\t\t\"method_name\": \"modifyToOpenTagByRawIssues(List)\",\n" +
            "\t\t\t\"rawIssue_id\": \"ce5503c4-02e5-4cf3-abdf-031e5d3e8839\",\n" +
            "\t\t\t\"code\": \"            tagged.put(\\\"itemId\\\", issue.getUuid());\\n\",\n" +
            "\t\t\t\"locationMatchResultDTOS\": null,\n" +
            "\t\t\t\"matched\": false,\n" +
            "\t\t\t\"matchedIndex\": 0\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";
    private  static  String res2="{\n" +
            "    \"code\": 200,\n" +
            "    \"msg\": \"success\",\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"involvedRepoCount\": 1,\n" +
            "            \"totalLevel\": 2.3333333333333335,\n" +
            "            \"efficiency\": 2.0,\n" +
            "            \"developer_name\": \"zhangyuhui\",\n" +
            "            \"DutyType\": \"在职\",\n" +
            "            \"value\": 1.0,\n" +
            "            \"quality\": 4.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"involvedRepoCount\": 1,\n" +
            "            \"totalLevel\": 2.6666666666666665,\n" +
            "            \"efficiency\": 1.0,\n" +
            "            \"developer_name\": \"zhouzhentao\",\n" +
            "            \"DutyType\": \"离职\",\n" +
            "            \"value\": 2.0,\n" +
            "            \"quality\": 5.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"involvedRepoCount\": 1,\n" +
            "            \"totalLevel\": 3.6666666666666665,\n" +
            "            \"efficiency\": 4.0,\n" +
            "            \"developer_name\": \"yuping\",\n" +
            "            \"DutyType\": \"在职\",\n" +
            "            \"value\": 3.0,\n" +
            "            \"quality\": 4.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"involvedRepoCount\": 1,\n" +
            "            \"totalLevel\": 2.6666666666666665,\n" +
            "            \"efficiency\": 1.0,\n" +
            "            \"developer_name\": \"liushuang\",\n" +
            "            \"DutyType\": \"离职\",\n" +
            "            \"value\": 2.0,\n" +
            "            \"quality\": 5.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"involvedRepoCount\": 1,\n" +
            "            \"totalLevel\": 4.0,\n" +
            "            \"efficiency\": 3.0,\n" +
            "            \"developer_name\": \"zhannanjie\",\n" +
            "            \"DutyType\": \"离职\",\n" +
            "            \"value\": 4.0,\n" +
            "            \"quality\": 5.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"involvedRepoCount\": 1,\n" +
            "            \"totalLevel\": 3.3333333333333335,\n" +
            "            \"efficiency\": 5.0,\n" +
            "            \"developer_name\": \"zhangjingfu\",\n" +
            "            \"DutyType\": \"在职\",\n" +
            "            \"value\": 3.0,\n" +
            "            \"quality\": 2.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"involvedRepoCount\": 1,\n" +
            "            \"totalLevel\": 4.0,\n" +
            "            \"efficiency\": 5.0,\n" +
            "            \"developer_name\": \"linshengwang\",\n" +
            "            \"DutyType\": \"离职\",\n" +
            "            \"value\": 5.0,\n" +
            "            \"quality\": 2.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"involvedRepoCount\": 1,\n" +
            "            \"totalLevel\": 3.0,\n" +
            "            \"efficiency\": 1.0,\n" +
            "            \"developer_name\": \"xuzhemin\",\n" +
            "            \"DutyType\": \"离职\",\n" +
            "            \"value\": 3.0,\n" +
            "            \"quality\": 5.0\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    private  static  String mockres="{\n" +
            "    \"code\": 200,\n" +
            "    \"msg\": \"success\",\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "                        \"uuid\": \"1ea900e3-cd48-4bd5-a493-9f58ae072746\",\n" +
            "                        \"start_line\": 307,\n" +
            "                        \"end_line\": 307,\n" +
            "                        \"bug_lines\": \"\",\n" +
            "                        \"start_token\": 0,\n" +
            "                        \"end_token\": 0,\n" +
            "                        \"file_path\": \"issue-service/src/main/java/cn/edu/fudan/issueservice/service/impl/BaseMappingServiceImpl.java\",\n" +
            "                        \"class_name\": null,\n" +
            "                        \"method_name\": \"modifyToOpenTagByRawIssues(List)\",\n" +
            "                        \"rawIssue_id\": \"ce5503c4-02e5-4cf3-abdf-031e5d3e8839\",\n" +
            "                        \"code\": \"            tagged.put(\\\"itemId\\\", issue.getUuid());\\n\",\n" +
            "                        \"locationMatchResultDTOS\": null,\n" +
            "                        \"matched\": false,\n" +
            "                        \"matchedIndex\": 0\n" +
            "        },\n" +
            "        {\n" +
            "                        \"uuid\": \"1ea900e3-cd48-4bd5-a493-9f58ae072746\",\n" +
            "                        \"start_line\": 307,\n" +
            "                        \"end_line\": 307,\n" +
            "                        \"bug_lines\": \"\",\n" +
            "                        \"start_token\": 0,\n" +
            "                        \"end_token\": 0,\n" +
            "                        \"file_path\": \"issue-service/src/main/java/cn/edu/fudan/issueservice/service/impl/BaseMappingServiceImpl.java\",\n" +
            "                        \"class_name\": null,\n" +
            "                        \"method_name\": \"modifyToOpenTagByRawIssues(List)\",\n" +
            "                        \"rawIssue_id\": \"ce5503c4-02e5-4cf3-abdf-031e5d3e8839\",\n" +
            "                        \"code\": \"            tagged.put(\\\"itemId\\\", issue.getUuid());\\n\",\n" +
            "                        \"locationMatchResultDTOS\": null,\n" +
            "                        \"matched\": false,\n" +
            "                        \"matchedIndex\": 0\n" +
            "        },\n" +
            "    ]\n" +
            "}";
    public  static  Object StringtoObeject(String s){
        ArrayList<Node> nodes =new ArrayList<>();
        nodes.add(new Node(-1));
        nodes.add(new Node(-2));
        String ss =JSON.toJSONString(nodes);
        System.out.println(ss);
        JSONObject obj=JSON.parseObject(res2);
        System.out.println(obj.getJSONArray("data").get(0));
        System.out.println(obj.get("msg"));
        System.out.println(obj.getString("msg"));
        System.out.println(obj.getString("data"));
        System.out.println(obj.get("data"));
        System.out.println("getClass"+obj.get("data").getClass());
        JSONObject thefirst =JSON.parseObject(json);
        System.out.println(thefirst.getJSONArray("detail").get(0));



        return null;
    }

    public static void main(String[] args) {
        System.out.println(StringtoObeject("dd"));
    }

}

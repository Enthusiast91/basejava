package com.enthusiast91.webapp;

import com.enthusiast91.webapp.model.Resume;

import java.util.*;

public class MainCollection {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_1 = new Resume(UUID_1, "Name1");
    private static final Resume RESUME_2 = new Resume(UUID_2, "Name2");
    private static final Resume RESUME_3 = new Resume(UUID_3, "Name3");

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);
        System.out.println(collection.toString());

        collection.removeIf(r -> Objects.equals(r.getUuid(), UUID_1));
        System.out.println(collection.toString());

        Map<String, Resume> map = new HashMap<String, Resume>() {{
            put(UUID_1, RESUME_1);
            put(UUID_2, RESUME_2);
            put(UUID_3, RESUME_3);
        }};

        for(Iterator<Map.Entry<String, Resume>> i = map.entrySet().iterator(); i.hasNext();) {
            Map.Entry entry = i.next();
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

        List<Resume> resumes = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
    }
}

package io.springboot.learning.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        //return topics.parallelStream().filter(t -> t.getId().equals(id)).findFirst().get();
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent())
            return optionalTopic.get();
        else
            throw new EntityNotFoundException("Topic not found");
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //return topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}

package main.services;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.InvalidMessageContentsException;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

import java.util.List;

public class SqsService {
    private AmazonSQS sqsClient;
    private String endpoint;

    public SqsService(AmazonSQS sqsClient, String endpoint) {
        this.sqsClient = sqsClient;
        this.endpoint = endpoint;
    }

    public SendMessageResult sendMessage(String msg) throws InvalidMessageContentsException {
        final SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(endpoint)
                .withMessageGroupId("gruppeSechs")
                .withMessageBody(msg);
        return sqsClient.sendMessage(sendMessageRequest);
    }

    public List<Message> receiveMessages(){
        return sqsClient.receiveMessage(endpoint).getMessages();
    }

    public void deleteMessage(Message msg){
        sqsClient.deleteMessage(endpoint, msg.getReceiptHandle());
    }
}

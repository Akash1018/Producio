package com.producio.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.producio.backend.dto.BidDTO;
import com.producio.backend.model.Bid;
import com.producio.backend.model.Item;
import com.producio.backend.model.User;
import com.producio.backend.repository.BidRepository;

@Service
public class BidService {
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private SimpMessagingTemplate template;

    public boolean addBid(BidDTO bidDTO) {
        User user = userService.getUser(bidDTO.getUserId());
        if(user == null) return false;
        Bid bid = new Bid();
        bid.setBidAmount(bidDTO.getBidAmount());;
        bid.setUser(user);
        bidRepository.save(bid);
        // add for item too

        template.convertAndSend("/topic/bids" + 123, "Bid placed"); // 123 -> item_id

        return true;
    }

    public String highestBid(String itemId) {
        return "CHL rha hai meri jaan";
    }
}

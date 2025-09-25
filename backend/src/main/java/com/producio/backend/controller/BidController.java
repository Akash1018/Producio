package com.producio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producio.backend.dto.BidDTO;
import com.producio.backend.service.BidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/bids")
public class BidController {
    @Autowired
    private BidService bidService;

    @PostMapping("/add")
    public ResponseEntity<String> postBid(@RequestBody BidDTO bid ) {
        boolean res = bidService.addBid(bid);
        if(!res) ResponseEntity.badRequest().body("invalid req");
        return ResponseEntity.ok("Bid added");
    }

    @GetMapping()
    public ResponseEntity<String> getHighestBid(@RequestParam String id) {
        return ResponseEntity.ok(bidService.highestBid(id));
    }
}

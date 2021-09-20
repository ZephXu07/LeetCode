package labuladong;

import java.util.*;

/**
 * Title: labuladong.Twitter
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-20
 */
public class Twitter {
    private static int timestamp = 0;

    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }

    }

    private static class User {
        private int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            this.head = null;
            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp ++;
            tweet.next = head;
            head = tweet;
        }
    }

    private Map<Integer, User> userMap = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(),
                (a, b) -> (b.time - a.time));
        for (int id:users) {
            Tweet tweet = userMap.get(id).head;
            if (null == tweet) {
                continue;
            }
            pq.add(tweet);
        }
        while (!pq.isEmpty()) {
            if (res.size() == 10) {
                break;
            }
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            if (tweet.next != null) {
                pq.add(tweet.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User follower = userMap.get(followerId);
            follower.unfollow(followeeId);
        }
    }
}

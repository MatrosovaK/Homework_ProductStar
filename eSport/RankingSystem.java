package org.eSport;

import java.util.*;

public class RankingSystem {
    private final Map<Integer, Player> allPlayers = new HashMap<>();

    private final TreeSet<Player> setPlayers = new TreeSet<>();
    private final TreeMap<Integer, Set<Player>> playerRankings = new TreeMap<>();


    public void addPlayer(Player player) {
        allPlayers.put(player.getId(), player);
        setPlayers.add(player);
        playerRankings.computeIfAbsent(player.getRating(), k -> new HashSet<>()).add(player);
        System.out.println("Добавлен игрок: " + player.getName() + " (ID: " + player.getId() + ", рейтинг: " + player.getRating() + " )");

    }

    public void updatePlayerRating(int playerId, int newRating) throws UserNotRegisteredException {
        Player oldPlayer = allPlayers.get(playerId);

        if (oldPlayer == null) {
            throw new UserNotRegisteredException("\nОшибка. пользователь с ID: " + playerId + " не зарегистрирован в системе");
        }
        System.out.println("Обновление рейтинга игрока: (Имя: " + oldPlayer.getName() + " , ID: " + playerId + " ). Новый рейтинг: " + newRating);

        if (oldPlayer.getRating() == newRating) {
            System.out.println("Ошибка. новый и старый рейтинги равны");
            return;
        }

        Set<Player> oldGroup = playerRankings.get(oldPlayer.getRating());
        if (oldGroup != null) {
            oldGroup.remove(oldPlayer);
            if (oldGroup.isEmpty()) {
                playerRankings.remove(oldPlayer.getRating());
            }
        }

        Player newPlayer = new Player(oldPlayer.getId(), oldPlayer.getName(), newRating);
        allPlayers.put(playerId, newPlayer);
        setPlayers.remove(oldPlayer);
        setPlayers.add(newPlayer);

        playerRankings.computeIfAbsent(newRating, k -> new HashSet<>()).add(newPlayer);
    }


    List<Player> getTopPlayers(int n) {

        return setPlayers.stream().limit(n).toList();
    }

    public void showTopPlayers(int n) {
        List<Player> topPlayers = getTopPlayers(n);
        if (n == 1) {
            System.out.println("Топ " + n + " игрок:");
        } else if ((2 <= n) && (n < 5)) {
            System.out.println("Топ " + n + " игрока:");
        } else if (n >= 5) {
            System.out.println("Топ " + n + " игроков:");
        }


        int count = 1;
        for (Player player : topPlayers) {
            System.out.println(count + ". " + player);
            count++;

        }
    }

    public int getPlayerRank(int playerId) throws UserNotRegisteredException{

        int rank = 1;
        for(Player player: setPlayers){
            if(player.getId() == playerId){
                System.out.println("Ранг игрока " + player.getName() + " (ID: " + playerId + ") равен " + rank);
                return rank;
            }
            rank++;
        }
        throw new UserNotRegisteredException("\nПопытка получить ранг игрока. \nОшибка. пользователь с ID: " + playerId + " не зарегистрирован в системе");

    }



        }











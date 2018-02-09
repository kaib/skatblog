package skatblock;

import javax.persistence.*;

@Entity
public class Game {
   private Game(){};

   public Game(Long id, GAME_TYPE game_type, boolean withJacks, Long isHand, Long isSchneider, Long isSchneiderAnnounced, Long isSchwarz, Long isSchwarzAnnounced, Long isOpen, boolean isWon, boolean isBock, Long multiplicator, Long series, Player player, Long timestamp) {
      this.id = id;
      this.game_type = game_type;
      this.withJacks = withJacks;
      this.isHand = isHand;
      this.isSchneider = isSchneider;
      this.isSchneiderAnnounced = isSchneiderAnnounced;
      this.isSchwarz = isSchwarz;
      this.isSchwarzAnnounced = isSchwarzAnnounced;
      this.isOpen = isOpen;
      this.isWon = isWon;
      this.isBock = isBock;
      this.multiplicator = multiplicator;
      this.series = series;
      this.player = player;
      this.timestamp = timestamp;
   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private GAME_TYPE game_type;
   private boolean withJacks;
   private Long isHand;
   private Long isSchneider;
   private Long isSchneiderAnnounced;
   private Long isSchwarz;
   private Long isSchwarzAnnounced;
   private Long isOpen;
   private boolean isWon;
   private boolean isBock;
   private Long multiplicator;

   private Long series;

   @ManyToOne
   private Player player;

   private Long timestamp;

   public Long getPoints(){
      return getGame_type().getValue() * getFinalMultiplicator();
   }

   public Long getFinalMultiplicator(){
      Long result = getMultiplicator() + isHand() + isSchneider() +isSchneiderAnnounced() +isSchwarz() + isSchwarzAnnounced() + isOpen();
      if(!isWon()) {
         result *= 2;
      }
      if(isBock()){
         result *= 2;
      }

      return result;

   }

   public Long isSchneider() {
      return isSchneider;
   }

   public void setSchneider(Long schneider) {
      isSchneider = schneider;
   }

   public Long isSchneiderAnnounced() {
      return isSchneiderAnnounced;
   }

   public void setSchneiderAnnounced(Long schneiderAnnounced) {
      isSchneiderAnnounced = schneiderAnnounced;
   }

   public Long isSchwarz() {
      return isSchwarz;
   }

   public void setSchwarz(Long schwarz) {
      isSchwarz = schwarz;
   }

   public Long isSchwarzAnnounced() {
      return isSchwarzAnnounced;
   }

   public void setSchwarzAnnounced(Long schwarzAnnounced) {
      isSchwarzAnnounced = schwarzAnnounced;
   }

   public Long isOpen() {
      return isOpen;
   }

   public void setOpen(Long open) {
      isOpen = open;
   }

   public boolean isWon() {
      return isWon;
   }

   public void setWon(boolean won) {
      isWon = won;
   }

   public boolean isBock() {
      return isBock;
   }

   public void setBock(boolean bock) {
      isBock = bock;
   }

   public Long getMultiplicator() {
      return multiplicator;
   }

   public void setMultiplicator(Long multiplicator) {
      this.multiplicator = multiplicator;
   }

   public Long getSeries() {
      return series;
   }

   public void setSeries(Long series) {
      this.series = series;
   }

   public Player getPlayer() {
      return player;
   }

   public void setPlayer(Player player) {
      this.player = player;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public GAME_TYPE getGame_type() {
      return game_type;
   }

   public void setGame_type(GAME_TYPE game_type) {
      this.game_type = game_type;
   }

   public boolean isWithJacks() {
      return withJacks;
   }

   public void setWithJacks(boolean withJacks) {
      this.withJacks = withJacks;
   }

   public Long isHand() {
      return isHand;
   }

   public void setHand(Long hand) {
      isHand = hand;
   }

   public Long getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(Long timestamp) {
      this.timestamp = timestamp;
   }
}


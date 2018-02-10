package skatblock.entitites;

import skatblock.GAME_TYPE;

import javax.persistence.*;

@Entity
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private GAME_TYPE game_type;
  private boolean withJacks;
  private boolean isHand;
  private boolean isSchneider;
  private boolean isSchneiderAnnounced;
  private boolean isSchwarz;
  private boolean isSchwarzAnnounced;
  private boolean isOpen;
  private boolean isWon;
  private boolean isBock;
  private Long multiplicator;

  @ManyToOne
  private Series series;
  @ManyToOne
  private Player player;
  @ManyToOne
  private Player vorhand;
  @ManyToOne
  private Player mittelhand;
  @ManyToOne
  private Player hinterhand;


  public Game(GAME_TYPE game_type, boolean withJacks, boolean isHand, boolean isSchneider, boolean isSchneiderAnnounced,
              boolean isSchwarz, boolean isSchwarzAnnounced, boolean isOpen, boolean isWon, boolean isBock,
              Long multiplicator, Series series, Player player, Player vorhand, Player mittelhand, Player hinterhand) {
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
    this.vorhand = vorhand;
    this.player = player;
    this.mittelhand = mittelhand;
    this.hinterhand = hinterhand;
  }

  private Game() {
  }


  public Long getPoints() {
    return getGame_type().getValue() * getFinalMultiplicator();
  }

  public Long getFinalMultiplicator() {
    Long result = getMultiplicator() + asLong(isHand()) + asLong(isSchneider()) + asLong(
            isSchneiderAnnounced()) + asLong(isSchwarz()) + asLong(isSchwarzAnnounced()) + asLong(isOpen());
    if (!isWon()) {
      result *= 2;
    }
    if (isBock()) {
      result *= 2;
    }

    return result;

  }

  private Long asLong(boolean bool) {
    return bool ? 1L : 0L;
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

  public boolean isHand() {
    return isHand;
  }

  public void setHand(boolean hand) {
    isHand = hand;
  }

  public boolean isSchneider() {
    return isSchneider;
  }

  public void setSchneider(boolean schneider) {
    isSchneider = schneider;
  }

  public boolean isSchneiderAnnounced() {
    return isSchneiderAnnounced;
  }

  public void setSchneiderAnnounced(boolean schneiderAnnounced) {
    isSchneiderAnnounced = schneiderAnnounced;
  }

  public boolean isSchwarz() {
    return isSchwarz;
  }

  public void setSchwarz(boolean schwarz) {
    isSchwarz = schwarz;
  }

  public boolean isSchwarzAnnounced() {
    return isSchwarzAnnounced;
  }

  public void setSchwarzAnnounced(boolean schwarzAnnounced) {
    isSchwarzAnnounced = schwarzAnnounced;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void setOpen(boolean open) {
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

  public Series getSeries() {
    return series;
  }

  public void setSeries(Series series) {
    this.series = series;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Player getVorhand() {
    return vorhand;
  }

  public void setVorhand(Player vorhand) {
    this.vorhand = vorhand;
  }

  public Player getMittelhand() {
    return mittelhand;
  }

  public void setMittelhand(Player mittelhand) {
    this.mittelhand = mittelhand;
  }

  public Player getHinterhand() {
    return hinterhand;
  }

  public void setHinterhand(Player hinterhand) {
    this.hinterhand = hinterhand;
  }
}


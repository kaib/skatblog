package skatblock;

public enum GAME_TYPE {
  DIAMONDS(9L), HEARTS(10L), SPADES(11L), CLUBS(12L), GRAND(24L), ZERO(23L), RAMSCH(1L);

  private Long value;

  GAME_TYPE(Long value) {
    this.value = value;
  }

  public Long getValue() {
    return this.value;
  }
}

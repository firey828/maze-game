package com.company.essentials;

public enum Direction {
    North("player_up.png"), South("player_down.png"), East("player_right.png"), West("player_left.png"),
    mNorth("mino_up.png"), mSouth("mino_down.png"), mEast("mino_right.png"), mWest("mino_left.png"),
    rNorth("rat_up.png"), rSouth("rat_down.png"), rEast("rat_right.png"), rWest("rat_left.png"),
    zNorth("zombie_up.png"), zSouth("zombie_down.png"), zEast("zombie_right.png"), zWest("zombie_left.png");

    private String _dir;

    public String getDir() { return _dir; }

    private Direction(String d) {
        _dir = d;
    }
}
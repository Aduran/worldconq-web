package com.umbrella.worldconq.actions;

import java.util.ArrayList;

import com.umbrella.worldconq.domain.GameListModel;

import domain.GameInfo;

public class ListGamesAction extends WorldConqAction {

	private static final long serialVersionUID = -8287753190029594857L;

	ArrayList<GameInfo> currentGames;
	ArrayList<GameInfo> openGames;

	GameListModel currentGameList;
	GameListModel openGameList;

	@Override
	public String execute() {

		currentGameList = getApp().getGameManager().getCurrentGameListModel();
		currentGames = new ArrayList<GameInfo>();
		for (int i = 0; i < currentGameList.getRowCount(); i++) {
			currentGames.add(i, currentGameList.getGameAt(i));
		}
		openGameList = getApp().getGameManager().getOpenGameListModel();
		openGames = new ArrayList<GameInfo>();
		for (int i = 0; i < openGameList.getRowCount(); i++) {
			openGames.add(i, openGameList.getGameAt(i));
		}
		return SUCCESS;
	}

	public ArrayList<GameInfo> getCurrentGames() {
		return currentGames;
	}

	public void setCurrentGames(ArrayList<GameInfo> currentGame) {
		this.currentGames = currentGame;
	}

	public ArrayList<GameInfo> getOpenGames() {
		return openGames;
	}

	public void setOpenGames(ArrayList<GameInfo> openGame) {
		this.openGames = openGame;
	}

}

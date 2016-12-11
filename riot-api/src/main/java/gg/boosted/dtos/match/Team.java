/*
 * Copyright 2014 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gg.boosted.dtos.match;

import java.util.List;

public class Team  {

	public List<BannedChampion> bans;
	public int baronKills;
	public int dominionVictoryScore;
	public int dragonKills;
	public boolean firstBaron;
	public boolean firstBlood;
	public boolean firstDragon;
	public boolean firstInhibitor;
	public boolean firstRiftHerald;
	public boolean firstTower;
	public int inhibitorKills;
	public int riftHeraldKills;
	public int teamId;
	public int towerKills;
	public int vilemawKills;
	public boolean winner;
	
}
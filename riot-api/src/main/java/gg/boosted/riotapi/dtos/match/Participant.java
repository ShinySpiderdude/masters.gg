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

package gg.boosted.riotapi.dtos.match;

import java.util.List;

public class Participant {
	
	public int championId;
	public String highestAchievedSeasonTier;
	public List<Mastery> masteries;
	public int participantId;
	public List<Rune> runes;
	public int spell1Id;
	public int spell2Id;
	public ParticipantStats stats;
	public int teamId;
	public ParticipantTimeline timeline;

}
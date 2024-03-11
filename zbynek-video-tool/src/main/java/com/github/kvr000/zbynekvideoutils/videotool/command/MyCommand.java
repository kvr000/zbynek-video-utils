/*
 * zbynek-video-tool - various video files manipulation utilities
 *
 * Copyright 2024-2024 Zbynek Vyskovsky mailto:kvr000@gmail.com http://github.com/kvr000/ https://github.com/zbynek-music-utils/ https://www.linkedin.com/in/zbynek-vyskovsky/
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

package com.github.kvr000.zbynekvideoutils.videotool.command;

import com.github.kvr000.zbynekvideoutils.videotool.ZbynekVideoTool;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.dryuf.cmdline.command.AbstractCommand;
import net.dryuf.cmdline.command.CommandContext;

import javax.inject.Inject;
import java.util.ListIterator;
import java.util.Map;


@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class MyCommand extends AbstractCommand
{
	private final ZbynekVideoTool.Options mainOptions;

	private Options options = new Options();

	protected boolean parseOption(CommandContext context, String arg, ListIterator<String> args) throws Exception
	{
		switch (arg) {
		case "-x":
			options.value = Long.parseLong(needArgsParam(options.value, args));
			return true;
		}
		return super.parseOption(context, arg, args);
	}

	@Override
	protected int validateOptions(CommandContext context, ListIterator<String> args) throws Exception
	{
		return EXIT_CONTINUE;
	}

	@Override
	public int execute() throws Exception
	{
		return 0;
	}

	protected Map<String, String> configParametersDescription(CommandContext context)
	{
		return ImmutableMap.of(
		);
	}

	@Override
	protected Map<String, String> configOptionsDescription(CommandContext context) {
		return ImmutableMap.of(
				"-x option", "the option"
		);
	}

	public static class Options
	{
		Long value;
	}
}

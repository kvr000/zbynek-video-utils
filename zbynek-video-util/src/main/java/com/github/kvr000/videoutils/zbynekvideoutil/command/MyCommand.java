package com.github.kvr000.videoutils.zbynekvideoutil.command;

import com.github.kvr000.videoutils.zbynekvideoutil.ZbynekVideoUtil;
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
	private final ZbynekVideoUtil.Options mainOptions;

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

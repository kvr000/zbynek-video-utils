package com.github.kvr000.videoutils.zbynekvideoutil;

import com.github.kvr000.videoutils.zbynekvideoutil.command.MyCommand;
import com.google.common.collect.ImmutableMap;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import net.dryuf.cmdline.app.AppContext;
import net.dryuf.cmdline.app.BeanFactory;
import net.dryuf.cmdline.app.CommonAppContext;
import net.dryuf.cmdline.app.guice.GuiceBeanFactory;
import net.dryuf.cmdline.command.AbstractParentCommand;
import net.dryuf.cmdline.command.Command;
import net.dryuf.cmdline.command.CommandContext;
import net.dryuf.cmdline.command.HelpOfHelpCommand;
import net.dryuf.cmdline.command.RootCommandContext;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Map;


/**
 * ZbynekVideoUtil entry point.  This class only executes subcommands.
 */
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Log4j2
public class ZbynekVideoUtil extends AbstractParentCommand
{
	private Options options;

	public static void main(String[] args)
	{
		runMain(args, (args0) -> {
			AppContext appContext = new CommonAppContext(Guice.createInjector(new GuiceModule()).getInstance(BeanFactory.class));
			return appContext.getBeanFactory().getBean(ZbynekVideoUtil.class).run(
				new RootCommandContext(appContext).createChild(null, "zbynek-video-util", null),
				Arrays.asList(args0)
			);
		});
	}

	protected CommandContext createChildContext(CommandContext commandContext, String name, boolean isHelp)
	{
		return commandContext.createChild(this, name, Map.of(Options.class, options));
	}

	@Override
	protected boolean parseOption(CommandContext context, String arg, ListIterator<String> args) throws Exception
	{
		switch (arg) {
		case "--vo":
			options.videoOutput = needArgsParam(options.videoOutput, args);
			return true;

		default:
			return super.parseOption(context, arg, args);
		}
	}

	@Override
	public void createOptions(CommandContext context)
	{
		this.options = new Options();
	}

	@Override
	protected String configHelpTitle(CommandContext context)
	{
		return "zbynek-video-util - various video manipulation tools";
	}

	@Override
	protected Map<String, String> configOptionsDescription(CommandContext context)
	{
		return ImmutableMap.of(
			"-vo video-output", "video output filename"
		);
	}

	@Override
	protected Map<String, Class<? extends Command>> configSubCommands(CommandContext context)
	{
		return ImmutableMap.<String, Class<? extends Command>>builder()
			.put("mycommand", MyCommand.class)
			.put("help", HelpOfHelpCommand.class)
			.build();
	}

	protected Map<String, String> configCommandsDescription(CommandContext context)
	{
		return ImmutableMap.<String, String>builder()
			.put("mycommand", "The first command")
			.put("help [command]", "Prints help")
			.build();
	}

	@Data
	public static class Options
	{
		String videoOutput;
	}

	public static class GuiceModule extends AbstractModule
	{
		@Override
		@SneakyThrows
		protected void configure()
		{
		}

		@Provides
		public BeanFactory beanFactory(Injector injector)
		{
			return new GuiceBeanFactory(injector);
		}
	}
}

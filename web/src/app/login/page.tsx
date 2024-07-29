import { Button } from '@/components/ui/button'
import { Input } from '@/components/ui/input'

export default function Login() {
  return (
    <main className="flex min-h-screen w-full items-center justify-center">
      <header className="fixed inset-0 flex h-20 w-full items-center justify-between bg-secondary px-10">
        <h1 className="text-2xl font-extrabold">Arc@nus.dev Learning</h1>
        <h2 className="text-sm">Seu portal de aprendizado Dev!</h2>
      </header>
      <section className="flex w-96 flex-col items-center space-y-5 rounded-lg bg-secondary px-5 py-10">
        <h2 className="text-xl">Faça seu Login!</h2>
        <form
          action=""
          className="flex w-full flex-col items-center justify-center space-y-5"
        >
          <div className="w-full space-y-2">
            <Input
              placeholder="Digite seu email..."
              className="bg-foreground text-background placeholder:text-slate-500"
              type="email"
              name="email"
            />
            <Input
              placeholder="Digite sua senha..."
              className="bg-foreground text-background placeholder:text-slate-500"
              type="password"
              name="password"
            />
          </div>
          <div className="space-y-2 text-center">
            <Button className="w-36" type="submit">
              Entrar
            </Button>
            <span className="block text-xs">Esqueci minha senha.</span>
          </div>
        </form>
      </section>
    </main>
  )
}
